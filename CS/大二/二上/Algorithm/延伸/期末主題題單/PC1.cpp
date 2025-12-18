// AC : unordered_map version
#include <bits/stdc++.h>
using namespace std;

int N, S, T, C;
vector<unordered_map<int, int>> adj;
vector<int> parent;

bool bfs() {
    fill(parent.begin(), parent.end(), -1);
    parent[S] = S;
    queue<int> q;
    q.push(S);

    while (!q.empty()) {
        int cur = q.front(); q.pop();
        for (auto& it : adj[cur]) {
            int next = it.first;
            int cap = it.second;

            if (parent[next] == -1 && cap > 0) {
                parent[next] = cur;
                if (next == T) return true;
                q.push(next);
            }
        }
    }
    return false;
}

int maxFlow() {
    int flow = 0;

    while (bfs()) {
        int pathFlow = INT_MAX;

        // 找瓶頸流量
        for (int v = T; v != S; v = parent[v]) {
            int u = parent[v];
            pathFlow = min(pathFlow, adj[u][v]);
        }

        // 更新殘留圖
        for (int v = T; v != S; v = parent[v]) {
            int u = parent[v];
            adj[u][v] -= pathFlow;
            adj[v][u] += pathFlow;
        }

        flow += pathFlow;
    }
    return flow;
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);

    int t = 1;
    while (cin >> N, N) {
        // init
        adj.assign(N + 1, unordered_map<int, int>());
        parent.assign(N + 1, -1);
        
        cin >> S >> T >> C;
        for (int i = 0; i < C; i++) {
            int u, v, c; cin >> u >> v >> c;
            adj[u][v] += c;
            adj[v][u] += c; 
        }

        cout << "Network " << t++ << "\n";
        cout << "The bandwidth is " << maxFlow() << ".\n\n";
    }
    return 0;
}