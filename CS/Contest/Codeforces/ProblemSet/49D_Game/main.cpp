#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n; cin >> n;
    string arr; cin >> arr;

    // dp[len][end with 0 or 1] 時的方法數
    vector<vector<int>> dp(n+1,vector<int>(2,0));
    for(int i = 1; i <= n; i++){
        if(arr[i-1] == '0'){
            dp[i][0] = dp[i-1][1];
            dp[i][1] = dp[i-1][0] + 1;
        }else{
            dp[i][0] = dp[i-1][1] + 1;
            dp[i][1] = dp[i-1][0];
        }
    }

    // 輸出
    cout << min(dp[n][1], dp[n][0]);
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    solve();
}