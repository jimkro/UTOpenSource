#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n; cin >> n;
    vector<int> v(n); for(int i=0;i<n;i++) cin >> v[i];
    sort(v.begin(), v.end());
    int mx = INT_MIN;
    for(int i = 1; i < n; i += 2){
        mx = max(mx, v[i] - v[i-1]);
    }
    cout << mx << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}