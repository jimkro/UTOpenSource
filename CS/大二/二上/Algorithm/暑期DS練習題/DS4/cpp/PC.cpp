#include <bits/stdc++.h>

using namespace std;

struct Node {
    int idx;
    int w1;
    int w2;
    Node(int idx, int w1, int w2) : idx(idx), w1(w1), w2(w2) {}

    // 定義比較運算子(for priority_queue) w1小的優先再w2小的
    bool operator>(const Node& other) const {
        if (w1 != other.w1) return w1 < other.w1;
        return w2 < other.w2;
    }
};

int main() {
    ios::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
    int N, E, src, dst;

    while(cin >> N >> E && (N != 0 || E != 0) && cin >> src >> dst){
        
        vector<vector<Node>> graph(N+1);
        for(int i=0;i<E;i++){
            int v1,v2,w1,w2;
            cin >> v1 >> v2 >> w1 >> w2;
            graph[v1].push_back({v2,w1,w2});
            graph[v2].push_back({v1,w1,w2});
        }

        // Dijkstra
        priority_queue<Node, vector<Node>, greater<Node>> pq;
        pq.push(Node(src,0,0));

        vector<pair<int,int>> dist(N+1, {100, 100});
        dist[src] = {0,0};

        while(!pq.empty()){
            auto [u, w1, w2] = pq.top(); pq.pop();
            for(auto& edge : graph[u]){
                int v = edge.idx;
                int new_w1 = w1 + edge.w1;
                int new_w2 = w2 + edge.w2;

                if(new_w1 >= 100 || new_w2 >= 100) continue; // 超過限制

                if(dist[v].first > new_w1 || (dist[v].first == new_w1 && dist[v].second > new_w2)){
                    dist[v] = {new_w1, new_w2};
                    pq.push(Node(v, new_w1, new_w2));
                }
            }
        }

        // output
        if(dist[dst].first == 100) cout << "Passed out\n";
        else cout << 100 - dist[dst].first << "% " << 100 - dist[dst].second << "%\n";

    }
    
    return 0;
}
