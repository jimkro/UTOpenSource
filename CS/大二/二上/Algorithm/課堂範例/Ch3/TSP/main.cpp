#include<bits/stdc++.h>
using namespace std;

long long TSP(const vector<vector<long long>>& w) {
    int n = w.size();
    int FULL = 1 << n;
    vector<vector<long long>> dp(FULL, vector<long long>(n, INF));
    dp[1][0] = 0; // start at 0, mask with bit0 on

    for(int mask = 1; mask < FULL; mask++){
        for(int u = 0; u < n; u++){
            if(!(mask & (1 << u)) || dp[mask][u]==INF) continue;
            
            for(int v = 0; v < n; v++){
                if(mask & (1 << v)) continue;
                dp[mask | (1 << v)][v] = min(dp[mask | (1 << v)][v], dp[mask][u] + w[u][v]);
            }
        }
    }
    long long ans = INF;
    for(int u = 0; u < n; u++) ans = min(ans, dp[FULL-1][u] + w[u][0]);
    return ans;
}


int main(){
    
}
