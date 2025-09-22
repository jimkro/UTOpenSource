#include <bits/stdc++.h>
#define llg long long
using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(nullptr);
    

    vector<int> a;
    int x; // 暫時讀取用的(少用一點變數或許會省一點?)

    // crewmate
    string line;
    if (!getline(cin, line)) return 0;
    stringstream ss(line);
    while (ss >> x) a.push_back(x);

    int n = a.size();

    // 計算最大子陣列和 (By Kadane's Algorithm)
    llg max_sum = LLONG_MIN, cur = 0;
    for (int i = 0; i < n; ++i) {
        cur = max((llg)a[i], cur + a[i]);
        max_sum = max(max_sum, cur);
    }

    // prefix sum
    vector<llg> prefix(n + 1, 0);
    for (int i = 0; i < n; ++i) prefix[i + 1] = prefix[i] + a[i];

    // 查詢各輸入
    while (cin >> x) {
        int Q = x;

        // 剪枝 (提速用?)
        if (Q > max_sum) {
            cout << "0\n";
            continue;
        }

        // Monotonic Queue 維護可能起點
        deque<int> dq;
        int ans = n + 1;

        for (int i = 0; i <= n; ++i) {
            while (!dq.empty() && prefix[i] - prefix[dq.front()] >= Q) {
                ans = min(ans, i - dq.front());
                dq.pop_front();
            }
            while (!dq.empty() && prefix[i] <= prefix[dq.back()]) {
                dq.pop_back();
            }
            dq.push_back(i);
        }

        cout << ans << "\n";
    }

    return 0;
}
