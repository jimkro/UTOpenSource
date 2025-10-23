#include<bits/stdc++.h>
using namespace std;
#define ll long long

int main() {
    ios::sync_with_stdio(0); cin.tie(0);

    int n,m;
    int num = 1;
    while(cin >> n >> m){
        if(n == 0 && m == 0) break;
        cout << "Twin Towers #" << num++ << "\n";
        vector<int> v1(n), v2(m);
        for(int i=0;i<n;i++) cin >> v1[i];
        for(int i=0;i<m;i++) cin >> v2[i];
        vector<vector<int>> dp(n + 1,vector<int>(m + 1));
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(v1[i-1] == v2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        cout << "Number of Tiles : " << dp[n][m] << "\n\n";
    }
    return 0;
}