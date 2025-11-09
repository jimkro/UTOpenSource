#include<bits/stdc++.h>
using namespace std;
int n, W, mx;
vector<int> weights, prices;

// === Ch4 DP ===
// 基礎款(教科書解法)
/*
    Time Complexity : O(n * W)
    Space Complexity : O(n * W)
*/
void dp_2D(){
    weights.assign(n, 0);
    prices.assign(n, 0);
    vector<vector<int>> dp(n+1, vector<int>(W+1));
    for(int i=0;i<n;i++) cin >> weights[i];
    for(int i=0;i<n;i++) cin >> prices[i];

    for(int i=1;i<=n;i++){
        for(int w=0;w<=W;w++){
            dp[i][w] = dp[i-1][w];
            if(w >= weights[i-1]) dp[i][w] = max(dp[i-1][w], prices[i-1] + dp[i-1][w - weights[i-1]]);
        }
    }
    cout << dp[n][W] << "\n";
}

// 技巧款
/*
    Time Complexity : O(n * W)
    Space Complexity : O(max(n, W))
*/
void dp_1D(){
    weights.assign(n, 0);
    prices.assign(n, 0);
    vector<int> dp(W + 1);
    for(int i=0;i<n;i++) cin >> weights[i];
    for(int i=0;i<n;i++) cin >> prices[i];

    for(int i = 0; i < n; i++){
        for(int w = W; w >= weights[i]; w--){
            dp[w] = max(dp[w], prices[i] + dp[w - weights[i]]);
        }        
    }

    cout << dp[W] << "\n";
}

// === Ch5 Brute Force ===
// brute_force 的 輔助函式
void dfs(int i, int total_w, int total_p){
    if(i == n){
        mx = max(mx, total_p);
        return;
    }
    dfs(i + 1, total_w, total_p);
    if(total_w + weights[i] <= W) dfs(i + 1, total_w + weights[i], total_p + prices[i]);
}

/*
    Time Complexity : O(2^n)
    Space Complexity : O(n)
*/
void brute_force(){
    weights.assign(n, 0);
    prices.assign(n, 0);
    for(int i=0;i<n;i++) cin >> weights[i];
    for(int i=0;i<n;i++) cin >> prices[i];
    mx = 0;
    dfs(0, 0, 0);
    
    cout << mx << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    while(cin >> n >> W){
        // dp_2D();
        // dp_1D();
        brute_force();
    }
    
}