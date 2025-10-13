#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    int T; cin >> T;
    
    while (T--) {
        int n; cin >> n;
        
        vector<vector<long long>> dist(n, vector<long long>(n));
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) cin >> dist[i][j];

        vector<int> order(n);
        for (int i = 0; i < n; i++) cin >> order[i];

        vector<bool> added(n);
        long long sum = 0;

        for (int k = 0; k < n; k++) {
            int x = order[n-k-1]; // 反向加入
            added[x] = true;

            // Floyd 更新
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(dist[i][x] + dist[x][j] < dist[i][j]) dist[i][j] = dist[i][x] + dist[x][j];
                }
            }

            // 計算目前已加入的塔間的最短距離總和
            for (int i = 0; i < n; i++) {
                if (!added[i]) continue;
                for (int j = 0; j < n; j++) {
                    if (!added[j]) continue;
                    sum += dist[i][j];
                }
            }
        }

        cout << sum << "\n";
    }
    return 0;
}
