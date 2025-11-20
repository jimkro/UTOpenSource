#include<bits/stdc++.h>
using namespace std;
vector<long long> dp;
string res = "";
int n;
void solve(){
    res += to_string(dp[n]) + "\n\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    dp.assign(16, 0);
    dp[0] = dp[1] = 1;
    for(int i = 2; i <= 15; i++){
        long long sum = 0;
        for(int j = 0; j < i; j++){
            sum += dp[j] * dp[i - 1 - j];
        }
        dp[i] = sum;
    }
    while(cin >> n) solve();
    res.resize(res.size() - 1);
    cout << res;
}