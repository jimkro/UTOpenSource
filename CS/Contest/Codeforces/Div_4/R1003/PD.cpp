#include<bits/stdc++.h>
using namespace std;
using ll = long long;

void solve(){
    // 輸入
    int n, m; cin >> n >> m;
    vector<vector<ll>> arrs(n,vector<ll>(m)); for(int i=0;i<n;i++) for(int j=0;j<m;j++) cin >> arrs[i][j];

    // 透過arrSum作為sort的依據，並保留idx以便對應
    vector<pair<ll,int>> mix(n); // [arrSum, idx]
    for(int i=0;i<n;i++){
        mix[i].first = accumulate(arrs[i].begin(), arrs[i].end(), 0L);
        mix[i].second = i;
    }

    // 把arrSum大的排在前面 (這樣才能吃到更多加權)
    sort(mix.begin(), mix.end(), greater<pair<int,int>>());

    // 加權
    int k = n * m;

    // 把所有值乘上加權的和算出來
    ll sum = 0;
    for(auto [_, idx] : mix) for(ll x : arrs[idx]) sum += x * k--;

    // 輸出
    cout << sum << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int t; cin >> t;
    while(t--) solve();
}