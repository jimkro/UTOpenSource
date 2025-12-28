#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

void solve() {
    int n;
    long long k;
    if (!(cin >> n >> k)) return;

    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];

    sort(a.begin(), a.end());

    vector<int> last_a, second_last_a;

    // 當 k > 0 且目前的狀態與上一次不同時進行模擬
    while (k > 0 && a != last_a) {
        second_last_a = last_a;
        last_a = a;
        k--;

        // 計算頻率陣列 F (注意題目 a[i] 範圍可能到 n)
        vector<int> F(n + 2, 0);
        for (int x : a) {
            if (x <= n) F[x]++;
        }

        // 尋找全體 mex
        int mex = 0;
        while (F[mex]) mex++;

        vector<int> B;
        int current_continuous_val = 0;
        for (int x : a) {
            if (F[x] > 1) {
                // 如果是重複值，新值為全體 mex
                B.push_back(mex);
            } else {
                // 如果是唯一值，新值為當前連續序列的 mex
                // 這對應 Python 裡的 mm 邏輯
                B.push_back(current_continuous_val);
            }
            
            // 更新 mm (current_continuous_val)
            if (x == current_continuous_val) {
                current_continuous_val++;
            }
        }

        sort(B.begin(), B.end());
        a = B;

        // 循環檢測：如果回到兩次前的狀態，直接對 k 取模
        if (a == second_last_a) {
            k %= 2; // Python 的 k &= 1 等同於 k %= 2
        }
    }

    // 計算總和
    long long sum = 0;
    for (int x : a) sum += x;
    cout << sum << "\n";
}

int main() {
    // 優化輸入輸出速度
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}