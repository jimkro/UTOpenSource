// AC
#include <bits/stdc++.h>
using namespace std;
 
void solve() {
    int n; cin >> n;
    vector<int> p(n);
    for (int i = 0; i < n; i++) cin >> p[i];
 
    vector<int> sufMax(n);
    sufMax[n - 1] = p[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        sufMax[i] = max(sufMax[i + 1], p[i]);
    }
 
    int preMin = p[0];
    for (int i = 0; i < n - 1; i++) {
        preMin = min(preMin, p[i]);
        if (preMin > sufMax[i + 1]) {
            cout << "No\n";
            return;
        }
    }
 
    cout << "Yes\n";
}
 
int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while (T--) solve();
    return 0;
}