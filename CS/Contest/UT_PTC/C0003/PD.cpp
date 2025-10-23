#include<bits/stdc++.h>
using namespace std;

int num = 1, n;
vector<vector<int>> cuts;

string re(int l, int r){
    if(l == r) return "A" + to_string(l);
    int k = cuts[l][r];
    return "(" + re(l, k) + " x " + re(k+1, r) + ")";
}

void solve(){
    vector<pair<int,int>> A(n+1); for(int i=1;i<=n;i++) cin >> A[i].first >> A[i].second;
    vector<vector<int>> dp(n+1,vector<int>(n+1,INT_MAX));
    cuts.assign(n+1,vector<int>(n+1,0));

    for(int i = 1; i <= n; i++) dp[i][i] = 0;
    
    for(int d = 1; d < n; d++){
        for(int i = 1; i <= n - d; i++){
            int j = i + d;
            for(int k = i; k < j; k++){
                int cost = A[i].first * A[k].second * A[j].second;
                int newVal = dp[i][k] + dp[k + 1][j] + cost;
                if(newVal < dp[i][j]){
                    dp[i][j] = newVal;
                    cuts[i][j] = k;
                }
            }
        }
    }

    cout << "Case " << num << ": " << re(1,n) << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    
    while(cin >> n && n != 0){
        solve();
        num++;
    }
}