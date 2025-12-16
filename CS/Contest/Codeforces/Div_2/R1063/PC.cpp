#include<bits/stdc++.h>
using namespace std;
vector<vector<int>> grid;
int n;

void solve(){
    cin >> n;
    grid.assign(2, vector<int>(n));
    for(int i=0;i<2;i++) for(int j=0;j<n;j++) cin >> grid[i][j];

    vector<int> pref_min_0(n), pref_max_0(n);
    vector<int> suff_min_1(n), suff_max_1(n);

    pref_min_0[0] = grid[0][0];
    pref_max_0[0] = grid[0][0];
    for(int j=1; j<n; j++){
        pref_min_0[j] = min(pref_min_0[j-1], grid[0][j]);
        pref_max_0[j] = max(pref_max_0[j-1], grid[0][j]);
    }

    suff_min_1[n-1] = grid[1][n-1];
    suff_max_1[n-1] = grid[1][n-1];
    for(int j=n-2; j>=0; j--){
        suff_min_1[j] = min(suff_min_1[j+1], grid[1][j]);
        suff_max_1[j] = max(suff_max_1[j+1], grid[1][j]);
    }

    vector<pair<int, int>> paths;
    for(int j=0; j<n; j++){
        int min_val = min(pref_min_0[j], suff_min_1[j]);
        int max_val = max(pref_max_0[j], suff_max_1[j]);
        paths.push_back({min_val, max_val});
    }

    int full = 2 * n;
    vector<int> M(full + 2, full + 1);
    vector<vector<int>> min_to_max(full + 1);
    for(auto [min_v, max_v] : paths){
        min_to_max[min_v].push_back(max_v);
    }

    priority_queue<int, vector<int>, greater<int>> pq;

    for(int l = full; l >= 1; l--){
        for(int max_v : min_to_max[l]){
            pq.push(max_v);
        }
        if(!pq.empty()){
            M[l] = pq.top();
        }
    }

    long long res = 0;
    for(int l = 1; l <= full; l++){
        int R_l = max(l, M[l]);
        if(R_l <= full){
            res += (long long)(full - R_l + 1);
        }
    }
    cout << res << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}