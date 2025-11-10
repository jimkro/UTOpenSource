#include<bits/stdc++.h>
#include <thread>   // 為了 std::this_thread::sleep_for
#include <chrono>   // 為了 std::chrono::milliseconds
#include <cstdlib>  // 為了 system("cls") 或 system("clear")
using namespace std;

int N;
vector<vector<int>> board;

int dx[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

void clearScreen() {
#ifdef _WIN32
    system("cls"); // Windows
#else
    system("clear"); // Linux / Mac
#endif
}

void printBoard() {
    cout << "--- 騎士巡遊 (" << N << "x" << N << ") ---" << endl;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
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

    clearScreen();
    printBoard();
    cout << "\nStep " << move_count << ": Knight moves to (" << x << ", " << y << ")" << endl;
    std::this_thread::sleep_for(std::chrono::milliseconds(50)); // 暫停 50 毫秒

    if (move_count == N * N) return true;

    vector<pair<int, int>> next_moves;

    for (int i = 0; i < 8; ++i) {
        int next_x = x + dx[i];
        int next_y = y + dy[i];

        if (isSafe(next_x, next_y)) {
            int degree = getDegree(next_x, next_y);
            next_moves.push_back({degree, i});
        }
    }

    sort(next_moves.begin(), next_moves.end());

    for (auto& move : next_moves) {
        int move_index = move.second;
        int next_x = x + dx[move_index];
        int next_y = y + dy[move_index];
        
        if (recurr(next_x, next_y, move_count + 1)) return true;
    }

    board[x][y] = 0;

    // 顯示回溯的過程
    clearScreen();
    printBoard(); // 顯示 '0'
    cout << "\nBacktracking from (" << x << ", " << y << ")..." << endl;
    std::this_thread::sleep_for(std::chrono::milliseconds(25)); // 回溯快一點

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

        if (recurr(0, 0, 1)) {
            cout << "\nTour complete!" << endl; // 成功訊息
        } else {
            cout << "N = " << N << " 無解\n";
        }
        cout << flush;
    }

    return 0;
}