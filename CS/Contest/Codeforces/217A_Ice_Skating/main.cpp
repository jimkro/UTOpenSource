#include<bits/stdc++.h>
using namespace std;

struct DSU{
    vector<int> parent;
    DSU(int N) : parent(N){
        iota(parent.begin(), parent.end(), 0);
    }
    
    int find(int i){
        return parent[i] == i ? i : parent[i] = find(parent[i]);
    }

    void unite(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) parent[x] = y;
    }
};

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int n; cin >> n;
    
    vector<pair<int,int>> points(n);
    for(int i = 0; i < n; i++){
        cin >> points[i].first >> points[i].second;
    }

    DSU dsu(n);

    for(int i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){
            if(points[i].first == points[j].first || points[i].second == points[j].second){
                dsu.unite(i,j);
            }
        }
    }

    unordered_set<int> st;
    for(int i = 0; i < n; i++) st.insert(dsu.find(i));
    int ans = st.size() - 1;
    cout << ans;

    return 0;
}