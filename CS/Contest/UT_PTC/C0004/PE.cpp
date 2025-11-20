#include<bits/stdc++.h>
using namespace std;
using ll = long long;
int n;
const ll MOD = 1000000;
vector<ll> dp(1000001);

void init(){
    dp[0] = 1;
    for(int i = 1; i <= 1000000; i++){
        dp[i] = dp[(int)(i - sqrt(i))] + dp[(int)log(i)] + dp[(int)(i * sin(i) * sin(i))];
        dp[i] %= MOD;
    }
}

void solve(){
    if(n == -1) return;
    cout << dp[n] << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    init();
    while(cin >> n) solve();
}