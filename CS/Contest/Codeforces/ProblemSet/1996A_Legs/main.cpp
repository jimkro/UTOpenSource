#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n; cin >> n;
    int res = n / 4 + (n % 4) / 2;
    cout << res << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int T; cin >> T;
    while(T--) solve();
}