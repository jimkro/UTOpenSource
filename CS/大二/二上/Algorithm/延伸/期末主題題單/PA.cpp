#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int N, E;
    while(cin >> N >> E){
        if(N == 0 && E == 0) break;

        vector<vector<int>> adj(N + 1);
        vector<bool> indegree(N + 1);
        vector<bool> visited(N + 1);
        int cnt = 0;

        while(E--){
            int u, v; cin >> u >> v;
            indegree[v] = true;
            adj[u].push_back(v);
        }

        queue<int> q;
        for(int i = 1; i <= N; i++) if(!indegree[i]) q.push(i);

        while(!q.empty()){
            int cur = q.front(); q.pop();
            if(visited[cur]) continue;
            visited[cur] = true;
            cnt++;
            cout << cur;
            if(cnt != N) cout << " ";

            for(int next : adj[cur]) if(!visited[next]) q.push(next);
        }
        cout << "\n";
    }
}