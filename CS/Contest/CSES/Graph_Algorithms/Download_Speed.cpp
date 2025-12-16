#include <bits/stdc++.h>
#define int long long
using namespace std;

int N, S = 1, T, C;
vector<unordered_map<int, int>> adj;
vector<int> parent;

bool bfs() {
    fill(parent.begin(), parent.end(), -1);
    parent[S] = S;
    queue<int> q;
    q.push(S);

    while (!q.empty()) {
        int cur = q.front(); q.pop();
        for (const auto& it : adj[cur]) {
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

        // 把流量累機下來
        flow += pathFlow;
    }
    return flow;
}

signed main() {
    ios::sync_with_stdio(0); cin.tie(0);

    while (cin >> N >> C) {
        // init
        adj.assign(N + 1, unordered_map<int, int>());
        parent.assign(N + 1, -1);
        T = N;

        for (int i = 0; i < C; i++) {
            int u, v, c; cin >> u >> v >> c;
            adj[u][v] += c; // 因為有多重邊所以用 +=
        }

        cout << maxFlow();
    }
    return 0;
}