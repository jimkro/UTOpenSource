#include <bits/stdc++.h>
using namespace std;
using ll = long long;

void solve(){
    ll len, tab, num; cin >> len >> tab >> num;
    if(num * tab <= len || tab == len) cout << "1\n";
    else cout << "2\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
    return 0;
}