#include<bits/stdc++.h>
using namespace std;

int N;
vector<vector<int>> board;

// 騎士的 8 個移動方向 (dx, dy)
int dx[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

void printBoard() {
    cout << "--- 騎士巡遊 (" << N << "x" << N << ") ---" << endl;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            // setw(4) 讓每個數字都佔 4 格，方便對齊
            cout << setw(4) << board[i][j] << " ";
        }
        cout << "\n";
    }
}

bool isSafe(int x, int y) {
    return (x >= 0 && x < N &&
            y >= 0 && y < N &&
            board[x][y] == 0);
}

int getDegree(int x, int y) {
    int count = 0;
    for (int i = 0; i < 8; ++i) {
        int next_x = x + dx[i];
        int next_y = y + dy[i];
        
        if (isSafe(next_x, next_y)) {
            count++;
        }
    }
    return count;
}

bool recurr(int x, int y, int move_count) {
    board[x][y] = move_count;

    if (move_count == N * N) return true;

    // { degree, move_index }
    vector<pair<int, int>> next_moves;

    for (int i = 0; i < 8; ++i) {
        int next_x = x + dx[i];
        int next_y = y + dy[i];

        if (isSafe(next_x, next_y)) {
            // 計算「下一步」的 "degree"
            int degree = getDegree(next_x, next_y);
            next_moves.push_back({degree, i});
        }
    }

    // 根據 degree由小排到大
    sort(next_moves.begin(), next_moves.end());

    for (auto& move : next_moves) {
        int move_index = move.second;
        int next_x = x + dx[move_index];
        int next_y = y + dy[move_index];
        
        if (recurr(next_x, next_y, move_count + 1)) return true;
    }

    board[x][y] = 0;
    return false;
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    while(1){
        cin >> N;
        if(N == 0) break;
        cout << "\n";
        board.clear();
        board.assign(N, vector<int>(N, 0));

        // 從 (0, 0) 開始，第 1 步
        if (recurr(0, 0, 1)) printBoard();
        else cout << "N = " << N << " 無解\n";
        cout << flush;   
    }

    return 0;
}