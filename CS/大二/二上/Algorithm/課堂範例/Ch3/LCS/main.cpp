#include <bits/stdc++.h>
using namespace std;

int main(){
    string a, b;
    while(cin >> a >> b){
        int n = a.size(), m = b.size();
        // dp[i][j]: a[0..i-1] 和 b[0..j-1] 的 LCS 長度
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));

        for(int i=1;i<=n;i++){ // i 代表 a 的長度 (即使用前 i 個字元)
            for(int j=1;j<=m;j++){ // j 代表 b 的長度 (即使用前 j 個字元)
                if(a[i-1] == b[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        cout << dp[n][m] << "\n";
    }
}