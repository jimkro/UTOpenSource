#include <bits/stdc++.h>
using namespace std;

// 全域
int n;
vector<int> path;
vector<bool> visited;
int caseNum = 1;
const int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

bool isPrime(int x) {
    if (x < 2) return false;
    for (int p : primes) if (x == p) return true;
    return false;
}

void dfs(int cur) {
    // base case
    if (cur == n + 1) {
        if (isPrime(path[n] + path[1])) {
            for (int i = 1; i <= n; i++) cout << path[i] << (i == n ? "" : " ");
            cout << "\n";
        }
        return;
    }

    // 嘗試填入 2 到 n 的數字
    for (int i = 2; i <= n; i++) {
        if (!visited[i] && isPrime(path[cur - 1] + i)) {
            visited[i] = true;
            path[cur] = i;
            
            dfs(cur + 1);
            
            visited[i] = false; // 回溯
        }
    }
}

void solve() {
    bool first = true;
    while (cin >> n) {
        // 初始化
        path.assign(n + 1, 0); 
        visited.assign(n + 1, false);
        path[1] = 1;
        visited[1] = true;

        cout << "Case " << caseNum++ << ":" << "\n";

        if (n % 2 == 0) dfs(2);

        cout << "\n";
    }
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    solve();
    return 0;
}