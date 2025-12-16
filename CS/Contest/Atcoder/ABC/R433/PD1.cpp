// solve by map
#include <bits/stdc++.h>
using namespace std;
#define int long long

// 計算數字位數
int getLen(int x){
    int res = 0;
    while(x) x /= 10, res++;
    return res;
}

void solve(){
    int n, m; cin >> n >> m;
    vector<int> v(n);
    
    // mp[{餘數, 長度}] = 出現次數
    map<pair<int, int>, int> mp;

    for(int i = 0; i < n; i++){
        cin >> v[i];
        int len = getLen(v[i]);
        int rem = v[i] % m;
        mp[{rem, len}]++;
    }

    int res = 0;
    for(int x : v){ // f(x, y) 的 x
        int cur = x % m;
        
        // 枚舉後面那個數字可能的長度 len(1~10)
        for(int len = 1; len <= 10; len++){ // y 的長度
            cur = (cur * 10) % m;
            int target = (m - cur) % m;
            if(mp.count({target, len})) res += mp[{target, len}];
        }
    }
    cout << res << "\n";
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    solve();
    return 0;
}