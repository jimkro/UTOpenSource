// WA
#include<bits/stdc++.h>
using namespace std;
#define int long long

void solve(){
    string s; cin >> s;
    int n = s.size();
    int res = 0;
    for(int i=0;i<n-1;i++){
        if(isdigit(s[i]) && isdigit(s[i+1]) && s[i] != s[i+1] && s[i+1] - s[i] == 1){
            int l = i, r = i + 1;
            while(l >= 0 && r < n && s[l] == s[i] && s[r] == s[i + 1]){
                l--;
                r++;
            }
            res += (r - l) / 2;
        }
    }
    cout << res << "\n";
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    solve();
    return 0;
}