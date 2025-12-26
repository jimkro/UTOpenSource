#include <bits/stdc++.h>
using namespace std;

void solve(){
    int n; cin >> n;
    vector<int> v(n); for(int& x : v) cin >> x;
    int mn = *min_element(v.begin(), v.end());
    for(int& x : v) x -= mn;
    int mn2 = INT_MAX;
    for(int i = 0; i < n; i++){
        if(v[i] == 0) continue;
        mn2 = min(mn2, v[i]);
    }
    cout << max(mn, mn2) << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}