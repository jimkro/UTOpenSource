#include<bits/stdc++.h>
using namespace std;

struct DSU {
    vector<int> parent, depth;
    
    DSU(int n) : parent(n+1), depth(n+1,1) {
        iota(parent.begin(), parent.end(), 0);
    }

    int find(int x) return parent[x] == x ? x : parent[x] = find(parent[x]);

    bool unite(int a, int b) {
        a = find(a); b = find(b);
        if(a == b) return false;
        if(depth[a] == depth[b]) depth[a]++;

        if(depth[a] < depth[b]) swap(a,b);
        parent[b] = a;
        
        return true;
    }
};

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int T;
    while(cin >> T){
        while(T--){
            int V, E; cin >> V >> E;
            vector<vector<int>> edges(E,vector<int>(3)); // {w, v1, v2}

            long long ans = 0;
            for(int i = 0; i < E;i++){
                int v1, v2, w; cin >> v1 >> v2 >> w;
                edges[i][0] = w;
                edges[i][1] = v1;
                edges[i][2] = v2;
                ans += w;
            }
            
            // 大邊在前面，因為我要的是"最大"生成樹
            sort(edges.begin(), edges.end(), greater<vector<int>>());
            
            DSU dsu(V);
            int cnt = 0; // 數邊數

            // Kuskal
            for(auto e : edges){
                if(dsu.unite(e[1],e[2])){
                    ans -= e[0];
                    cnt++;
                    if(cnt == V - 1) break;
                }
            }
            
            // 輸出
            cout << ans << "\n";
        }

        // 每一筆後面有跟一個 0 ，所以把他讀掉
        int skipZero; cin >> skipZero;
    }
}