// Solve by Kruskal Algorithm
#include <bits/stdc++.h>
using namespace std;

struct Edge {
    int u, v, w;
    bool operator<(const Edge& other) const {
        return w < other.w;
    }
};

// Disjoint Set Union (並查集)
struct DSU {
    vector<int> parent, sz;
    DSU(int n) : parent(n+1), sz(n+1,1) {
        iota(parent.begin(), parent.end(), 0);
    }
    int find(int x) {
        return parent[x] == x ? x : parent[x] = find(parent[x]);
    }
    bool unite(int a, int b) {
        a = find(a); b = find(b);
        if(a == b) return false;
        if(sz[a] < sz[b]) swap(a,b);
        parent[b] = a;
        sz[a] += sz[b];
        return true;
    }
};

int main() {
    ios::sync_with_stdio(false); cin.tie(nullptr);

    int T;
    if(!(cin >> T)) return 0;

    while(T--) {
        int V, E;
        if(!(cin >> V >> E)) break;

        vector<Edge> edges;
        edges.reserve(E);
        for(int i = 0; i < E; i++) {
            int u, v, w;
            if(!(cin >> u >> v >> w)) break;
            edges.push_back({u,v,w});
        }

        sort(edges.begin(), edges.end());
        DSU dsu(V);

        int mst_cost = 0, cnt = 0;
        for(auto &e : edges){
            if(dsu.unite(e.u, e.v)){
                mst_cost += e.w;
                cnt++;
                if(cnt == V-1) break; // MST完成
            }
        }

        cout << mst_cost << "\n";
    }

    return 0;
}
