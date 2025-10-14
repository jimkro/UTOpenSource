#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(0);

    int N, M;

    while (cin >> N >> M) {
        vector<vector<bool>> multi(N + 1, vector<bool>(N + 1, true));

        // 模擬 M 輪
        for (int r = 0; r < M; r++) {
            unordered_map<int, vector<pair<int,int>>> mp;

            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (!multi[i][j]) continue;
                    int tmp = (r % 2 == 0 ? i + j : i * j);
                    mp[tmp].push_back({i, j});
                }
            }

            for (auto &kv : mp) {
                auto &vec = kv.second;
                if (vec.size() == 1) {
                    int a = vec[0].first, b = vec[0].second;
                    multi[a][b] = false;
                }
            }
        }

        vector<pair<int,int>> results;
        unordered_map<int, vector<pair<int,int>>> mp;

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (!multi[i][j]) continue;
                int tmp = (M % 2 == 0 ? i + j : i * j);
                mp[tmp].push_back({i, j});
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (!multi[i][j]) continue;
                int tmp = (M % 2 == 0 ? i + j : i * j);
                if (mp[tmp].size() == 1) results.push_back(mp[tmp][0]);
            }
        }

        // 直接輸出
        cout << results.size() << "\n";
        for (auto &p : results) cout << p.first << " " << p.second << "\n";
    }

    return 0;
}
