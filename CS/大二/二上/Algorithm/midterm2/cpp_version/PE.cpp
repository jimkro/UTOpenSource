#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;

void solve() {
    int W, N; cin >> W >> N;
    vector<vector<long long>> dp(W + 1, vector<long long>(N + 1, 0));
    cin.ignore();
    dp[1][1] = 1;

    for(int i = 0; i < W; i++){
        string line; getline(cin, line);
        stringstream ss(line);
        int x, y;
        bool first = true;

        while(ss >> y){
            if(first){
                x = y;
                first = !first;
            }else{
                dp[x][y] = -1;
            }
        }
    }

    for(int i = 1; i <= W; i++){
        for(int j = 1; j <= N; j++){
            if(dp[i][j] == -1) continue;
            if(dp[i-1][j] != -1) dp[i][j] += dp[i-1][j];
            if(dp[i][j-1] != -1) dp[i][j] += dp[i][j-1]; 
            dp[i][j] %= MOD;
        }
    }

    dp[W][N] = max(dp[W][N], 0LL);
    cout << dp[W][N] << "\n";
}

int main() {
    ios::sync_with_stdio(0);cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
    return 0;
}