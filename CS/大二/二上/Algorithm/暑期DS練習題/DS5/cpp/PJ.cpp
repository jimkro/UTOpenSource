#include <bits/stdc++.h>

using namespace std;

struct Node {
    int l, r;
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    while (cin >> n) {
        vector<Node> nodes(n + 1);
        for (int i = 1; i <= n; i++) {
            cin >> nodes[i].l >> nodes[i].r;
        }

        // BFS
        queue<pair<int, int>> q;
        q.push({1, 1}); // (節點, 深度)
        int maxDepth = 1;

        while (!q.empty()) {
            auto [curr, depth] = q.front();
            q.pop();
            maxDepth = max(maxDepth, depth);

            if (nodes[curr].l != 0)
                q.push({nodes[curr].l, depth + 1});
            if (nodes[curr].r != 0)
                q.push({nodes[curr].r, depth + 1});
        }

        cout << maxDepth << "\n";
    }
    return 0;
}
