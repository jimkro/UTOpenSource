#include <bits/stdc++.h>

using namespace std;


int main() {
    ios::sync_with_stdio(false);
    // cin.tie(nullptr);

    int n;
    while(cin >> n){
        // 輸入 
        int start, end; cin >> start >> end; cin.ignore();
        
        vector<vector<int>> adj(n+1, vector<int>());
        for(int i = 0; i < n; i++){
            string line; getline(cin, line);
            istringstream ss(line);
            int u; ss >> u;
            int v;
            while(ss >> v){
                adj[u].push_back(v);
                adj[v].push_back(u);
            }
        }

        // BFS
        unordered_set<int> visited;
        queue<pair<int, int>> q; // (node, distance)
        q.push({start, 0});
        visited.insert(start);
        int ans = -1;
        while(!q.empty()){
            auto [node, dist] = q.front(); q.pop();
            if(node == end){
                ans = dist;
                break;
            }
            for(auto& neighbor : adj[node]){
                if(visited.count(neighbor)) continue;
                visited.insert(neighbor);
                q.push({neighbor, dist + 1});
            }
        }
        cout << ans << "\n";

    }
    return 0;
}
