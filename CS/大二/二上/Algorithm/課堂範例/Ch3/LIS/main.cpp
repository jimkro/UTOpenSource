#include<bits/stdc++.h>
using namespace std;

int main(){
    string s;
    while(cin >> s){
        int n = s.size(), ans = 0;
        vector<int> dp(n, 1);

        for(int r = 0; r < n; r++){
            for(int l = 0;l < r; l++){
                if(s[l] < s[r]){
                    dp[r] = max(dp[r], dp[l] + 1);
                }
            }
            ans = max(ans, dp[r]);
        }
        
        cout << ans << "\n";
    }
}