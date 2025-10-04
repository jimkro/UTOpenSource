#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T; cin >> T;
    while(T--) {
        int V, E, S; cin >> V >> E >> S;
        vector<vector<pair<int,int>>> graph(V+1); // pair : {鄰居,權重}

        for(int i = 0; i < E; i++){
            int v1,v2,w;
            cin >> v1 >> v2 >> w;
            graph[v1].push_back({v2,w});
            graph[v2].push_back({v1,w}); // 無向圖
        }

        // Dijkstra
        vector<int> dist(V+1, INT_MAX);
        dist[S] = 0;
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<>> pq; // pair : {距離,節點}
        pq.push({0,S});

        while(!pq.empty()){
            auto [d,u] = pq.top(); pq.pop();
            if(d > dist[u]) continue; // 已經找到過更短的路徑了
            for(auto [v,w] : graph[u]){
                if(dist[v] > dist[u] + w){ // 找到更短的路徑
                    dist[v] = dist[u] + w;
                    pq.push({dist[v], v});
                }
            }
        }

        for(int i = 1;i <= V;i++) cout << dist[i] << " ";
        cout << "\n";
    }
}
