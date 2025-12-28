#include <bits/stdc++.h>
#define int long long
using namespace std;

void solve(){
    int k, x; cin >> k >> x;
    x *= (int)(pow(2, k));
    cout << x << "\n";
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}