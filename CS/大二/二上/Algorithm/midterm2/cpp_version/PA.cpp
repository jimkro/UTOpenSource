#include <bits/stdc++.h>
using namespace std;
int dx[] = {0, 0, 1, -1, 1, 1, -1, -1};
int dy[] = {1, -1, 0, 0, -1, 1, -1, 1};

int main() {
    // ios::sync_with_stdio(0);cin.tie(0);
    int T; cin >> T;
    for(int t = 1; t <= T; t++){
        int n, m, d1, d2; cin >> n >> m >> d1 >> d2;
        vector<string> grid(n); for(auto& s : grid) cin >> s;
        vector<vector<int>> res(n, vector<int>(m));

        printf("Airplane #%d:\n", t);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char c = grid[i][j];

                if(c == 'V'){
                    for(int k = 0; k < 8; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        int d = k < 4 ? d1 : d2;
                        if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] != 'V'){
                            res[nx][ny] = max(res[nx][ny], d);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'V') cout << "V";
                else cout << res[i][j];
            }
            cout << "\n";
        }
    }
    return 0;
}