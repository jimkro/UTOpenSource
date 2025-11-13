#include <bits/stdc++.h>
using namespace std;
using ll = long long;

void solve() {
    int n; cin >> n;
    vector<ll> a(n), c(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    
    ll total_cost = 0;
    for (int i = 0; i < n; i++) {
        cin >> c[i];
        total_cost += c[i];
    }

    if (n == 0) {
        cout << "0\n";
        return;
    }

    vector<ll> dp(n);
    ll max_saved_cost = 0;

    for (int i = 0; i < n; i++) {
        dp[i] = c[i]; 
        for (int j = 0; j < i; j++) {
            if (a[j] <= a[i]) dp[i] = max(dp[i], dp[j] + c[i]);
        }
        max_saved_cost = max(max_saved_cost, dp[i]);
    }

    cout << total_cost - max_saved_cost << "\n";
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while (T--) solve();
}