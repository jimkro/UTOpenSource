#include <bits/stdc++.h>
#define llg long long
using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(nullptr);
    
    // crewmate
    vector<int> arr; int x;// x : 暫時讀取用的(少用一點變數或許會省一點?)

    string line;
    if (!getline(cin, line)) return 0;
    stringstream ss(line); while (ss >> x) arr.push_back(x);
    

    int n = arr.size();

    // 計算最大子陣列和 (By Kadane's Algorithm)
    llg max_sum = LLONG_MIN, curr = 0;
    for (int i = 0; i < n; i++) {
        curr = max((llg)arr[i], curr + arr[i]);
        max_sum = max(max_sum, curr);
    }

    // prefix sum, prefix[n] = arr[0] + ... + arr[n-1]
    vector<llg> prefix(n + 1, 0);
    for (int i = 1; i <= n; i++) prefix[i] = prefix[i-1] + arr[i-1];

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
        int ans = n;

        for (int i = 0; i <= n; i++) {
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
