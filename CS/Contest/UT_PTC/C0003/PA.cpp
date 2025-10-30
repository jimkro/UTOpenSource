#include <bits/stdc++.h>
using namespace std;
#define ll long long

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    while (cin >> n) {
        vector<int> v(n);
        for (int i = 0; i < n; i++) cin >> v[i];
        sort(v.begin(), v.end());

        int ans1 = v[(n - 1) / 2];
        int ans2 = 0;
        int ans3 = 0;

        if (n % 2 == 1) {
            // 奇數 → 只有一個中位數
            ans2 = count(v.begin(), v.end(), ans1);
            ans3 = 1;
        } else {
            // 偶數 → 有兩個中位數範圍
            int bot = v[n / 2 - 1];
            int top = v[n / 2];
            for (int x : v) {
                if (x >= bot && x <= top) ans2++;
            }
            ans3 = top - bot + 1;
        }

        cout << ans1 << " " << ans2 << " " << ans3 << "\n";
    }

    return 0;
}
