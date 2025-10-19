/*
    Gemini神仙解法
*/
#include <bits/stdc++.h>

// 計算從 1 到 n 的所有數字的最大奇因數之和
long long solve(long long n) {
    // 遞迴的基礎情況 (Base Case)
    if (n == 0) return 0;

    // 1. 計算奇數部分的貢獻
    // 在 [1, n] 範圍內的奇數數量為 (n+1)/2 (使用整數除法)
    // 例如 n=5, (5+1)/2 = 3, 奇數為 1, 3, 5
    // 例如 n=6, (6+1)/2 = 3, 奇數為 1, 3, 5
    long long num_odd_numbers = (n + 1) / 2;

    // 對於奇數，其最大奇因數就是它本身。
    // 前 k 個奇數 (1, 3, 5, ...) 的和等於 k*k。
    long long sum_for_odds = num_odd_numbers * num_odd_numbers;

    // 2. 計算偶數部分的貢獻
    // 對於偶數 k = 2*j, GOD(k) = GOD(j)。
    // 所以 sum(GOD(2), GOD(4), ..., GOD(2*floor(n/2)))
    // 等於 sum(GOD(1), GOD(2), ..., GOD(floor(n/2)))
    // 這恰好是對 solve(n/2) 的遞迴呼叫。
    long long sum_for_evens = solve(n / 2);

    // 總和等於兩部分之和
    return sum_for_odds + sum_for_evens;
}

int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    
    int t; cin >> t;
    
    while (t--) {
        long long a, b;
        cin >> a >> b;

        // sum(A, B) = sum(1, B) - sum(1, A-1)
        long long result = solve(b) - solve(a - 1);

        cout << result << "\n";
    }

    return 0;
}