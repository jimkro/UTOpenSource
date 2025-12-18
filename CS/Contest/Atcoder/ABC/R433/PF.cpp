#include<bits/stdc++.h>
using namespace std;
#define int long long
const int MOD = 998244353;

int C(int n, int m){
    int up = n;
    int low = min(m, n - m);
    int res = 1;
    for(int i=1;i<=low;i++){
        res = res * up / i;
        res %= MOD;
        up--;
    }
    return res;
}

int cal(int n, int m){
    int upper = min(n,m);
    int i = 1;
    int res = 0;
    // cout << n << " " << m << "\n";
    while(i <= upper){
        res += C(n,i) * C(m, i);
        // cout << n << " " << i << "\n";
        // cout << res << "\n";
        res %= MOD;
        i++;
    }
    return res;
}

void solve(){
    string s; cin >> s;
    int n = s.size();
    vector<int> cnt(10); for(char c : s) cnt[c - '0']++;
    int res = 0;
    for(int i = 0; i <= 8; i++){
        int mxP = 0;
        int sum1 = 0, sum2 = cnt[i+1];
        int mx1 = -1, mx2 = -1;
        for(int j = 0; j < n; j++){
            if(s[j]-'0' == i){
                sum1++;
            }
            if(s[j]-'0' == i + 1){
                sum2--;
            }
            if(sum1 * sum2 > mxP){
                mxP = sum1 * sum2;
                mx1 = sum1;
                mx2 = sum2;
            }
        }
        if(mx1 == -1 && mx2 == -1) continue;
        res += cal(mx1, mx2);
    }
    cout << res;
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    solve();
    return 0;
}