#include <bits/stdc++.h>
using namespace std;
#define int long long

const int MOD = 1e9 + 7;
int n, m;

void solve(){
    // 讓 n 為較小邊，減少 mask 狀態數
    if(n > m) swap(n, m);

    // 預處理單個 Row 合法的 mask
    const int FULL = (1LL << n) - 1; // 全滿 -> ex : 1111111
    vector<int> valid;
    for(int i = 0; i <= FULL; i++){
        if((i &(i >> 1)) == 0) valid.push_back(i); // 沒有黑色相鄰
    }

    // init
    vector<int> dp(valid.size(), 1); // dp[i] 表示當前列狀態為 valid[i] 的方法數

    // 2 ~ m Row
    for(int row = 2; row <= m; row++){
        vector<int> next_dp(valid.size(), 0);
        for(int i = 0; i < valid.size(); i++){ // curr mask
            for(int j = 0; j < valid.size(); j++){ // prev mask
                // 檢查兩列是否有黑色相鄰
                if((valid[i] & valid[j]) == 0){
                    next_dp[i] = (next_dp[i] + dp[j]) % MOD;
                }
            }
        }
        dp = next_dp;
    }

    // sum
    int res = 0;
    for(int x : dp) res = (res + x) % MOD;
    cout << res << "\n";
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    while(cin >> n >> m &&(n != 0 || m != 0)) solve();
    return 0;
}