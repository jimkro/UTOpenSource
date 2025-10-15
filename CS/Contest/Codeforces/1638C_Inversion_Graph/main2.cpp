/*
    skill : DSU
    note : TLE了QQ
*/
#include<bits/stdc++.h>
using namespace std;

struct DSU{
    vector<int> parent, depth;
    DSU(int N) : parent(N), depth(N,1){
        iota(parent.begin(), parent.end(), 0);
    }

    int find(int x){
        return parent[x] == x ? x : parent[x] = find(parent[x]);
    }

    void unite(int i, int j){
        i = find(i);
        j = find(j);
        
        if(i != j){
            if(depth[i] == depth[j]) depth[i]++;
            if(depth[i] < depth[j]) swap(i,j);
            parent[j] = i;
        }
    }
};

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    
    int T; cin >> T;

    while(T--){
        int n; cin >> n;
        vector<int> v(n);
        for(int i = 0; i < n; i++) cin >> v[i];

        DSU dsu(n);

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(v[i] > v[j]) dsu.unite(i, j);
            }
        }

        unordered_set<int> st;
        for(int i = 0; i < n; i++) st.insert(dsu.find(i));
        cout << st.size() << "\n";
    }
    
    return 0;
}