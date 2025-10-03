// solve by DP (dynamic programming)
#include <bits/stdc++.h>
using namespace std;

int main(){
    int n, target;
    while(cin >> n >> target){
        vector<int> coins(n);
        for(int i=0; i<n; i++) cin >> coins[i];
        
        // dp[i]: 最少的硬幣數量湊出 i 元
        vector<int> dp(target + 1, INT_MAX);
        dp[0] = 0;
        for(int i=1; i<=target; i++){
            for(int j=0; j<n; j++){
                if(i - coins[j] < 0) continue;
                if(dp[i - coins[j]] != INT_MAX){
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // for(int x : dp) cout << x << " ";
        // cout << "\n";

        // output
        if(dp[target] == INT_MAX) cout << -1 << "\n";
        else cout << dp[target] << "\n";
    }
    return 0;
}