// AC : adj matrix
#include <bits/stdc++.h>
using namespace std;
int N, S, T, C;
vector<vector<int>> capacity;
vector<int> parent;
bool bfs(){
    fill(parent.begin(), parent.end(), -1);
    parent[S] = S;
    queue<int> q;
    q.push(S);

    while (!q.empty()) {
        int cur = q.front(); q.pop();
        for (int next = 0; next <= N; next++) {
            if (parent[next] == -1 && capacity[cur][next] > 0) {
                parent[next] = cur;
                if (next == T) return true;
                q.push(next);
            }
        }
    }
    return false; // 找不到路徑
}

int maxFlow(){
    int flow = 0;

    while(bfs()){
        int pathFlow = INT_MAX;

        // get path flow
        for(int v = T; v != S; v = parent[v]){
            int u = parent[v];
            pathFlow = min(pathFlow, capacity[u][v]);
        }

        // update 
        for (int v = T; v != S; v = parent[v]) {
            int u = parent[v];
            capacity[u][v] -= pathFlow;
            capacity[v][u] += pathFlow;
        }   

        flow += pathFlow;
    }
    
    return flow;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int t = 1;
    while(cin >> N, N){
        // init
        capacity.assign(N + 1, vector<int>(N + 1, 0));
        parent.assign(N + 1, -1);
        
        // input
        cin >> S >> T >> C;
        for(int i = 0; i < C; i++){
            int u, v, c; cin >> u >> v >> c;
            capacity[u][v] += c;
            capacity[v][u] += c;
        }

        // output
        cout << "Network " << t++ << "\n";
        cout << "The bandwidth is " << maxFlow() << ".\n\n";
    }

}