// Solve by Prim Algorithm
#include <bits/stdc++.h>
using namespace std;

struct Edge { int to, w; };

int main() {
    ios::sync_with_stdio(false); cin.tie(nullptr);

    int V, E;
    while(cin >> V >> E) {

        vector<vector<Edge>> graph(V+1);
        for(int i = 0; i < E; i++) {
            int u, v, w;
            cin >> u >> v >> w;
            graph[u].push_back({v, w});
            graph[v].push_back({u, w});
        }

        vector<bool> visited(V+1, false);
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<>> pq;
        pq.push({0, 1}); // {權重, 節點}
        int mst_cost = 0, cnt = 0;

        while(!pq.empty() && cnt < V) {
            auto [w, u] = pq.top(); pq.pop();
            if(visited[u]) continue;
            visited[u] = true;
            mst_cost += w;
            cnt++;

            for(auto &e : graph[u]){
                if(!visited[e.to]){
                    pq.push({e.w, e.to});
                }
            }
        }

        cout << mst_cost << "\n";
    }

    return 0;
}
