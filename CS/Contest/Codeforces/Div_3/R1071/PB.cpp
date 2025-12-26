#include <bits/stdc++.h>
using namespace std;

void solve(){
    int n; cin >> n;
    vector<int> v(n); for(int& x : v) cin >> x;
    long long tot = 0;
    for(int i = 1; i < n; i++) tot += abs(v[i] - v[i-1]);
    int mx = max(abs(v[0] - v[1]), abs(v[n-1] - v[n-2]));

    for(int i = 1; i < n - 1; i++){
        mx = max(mx, abs(v[i] - v[i-1]) + abs(v[i] - v[i+1]) - abs(v[i+1] - v[i-1]));
    }
    cout << tot - mx << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}