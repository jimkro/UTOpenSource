#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n, k; cin >> n >> k;
    string s; cin >> s;
    int l=0, cnt = 0, res = 0;

    for(int r = 0; r < n; r++){
        if(r - l >= k) cnt -= s[l++] - '0';
        if(s[r] == '1' && cnt == 0) res++;
        cnt += s[r] - '0';
    }
    cout << res << "\n";
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;

    while(T--) solve();
}