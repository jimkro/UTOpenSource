// AC
#include <bits/stdc++.h>
using namespace std;

struct Move{
    int x, y, degree;
    Move(){}
    Move(int x, int y, int degree) : x(x), y(y), degree(degree){}

    bool operator<(const Move& m) const {
        return degree < m.degree;
    }
};

int startX, startY, cnt = 1;
vector<int> dx = {1, 1, 2, 2, -1, -1, -2, -2};
vector<int> dy = {2, -2, 1, -1, 2, -2, 1, -1};
vector<vector<int>> grid(8, vector<int>(8));

bool valid(int x, int y){
    return x >= 0 && x < 8 && y >= 0 && y < 8 && grid[x][y] == 0;
}

int cal(int x, int y){ // 數能走的位置數
    int res = 0;
    for(int i = 0; i < 8; i++){
        int nextX = x + dx[i];
        int nextY = y + dy[i];
        if(valid(nextX, nextY)) res++;
    }
    return res;
}

bool move(int x, int y){
    grid[x][y] = cnt++;
    if(cnt == 65) return true;
    vector<Move> next;
    
    for(int i = 0; i < 8; i++){
        int nextX = x + dx[i];
        int nextY = y + dy[i];
        if(valid(nextX, nextY)) next.push_back({nextX, nextY, cal(nextX, nextY)});
    }
    sort(next.begin(), next.end());
    
    for(auto& nt : next){
        if(move(nt.x, nt.y)) return true;
    }

    cnt--;
    grid[x][y] = 0;
    
    return false;
}
int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> startY >> startX;
    
    move(startX-1, startY-1);
    for(int i = 0; i < 8; i++){
        for(int j = 0; j < 8; j++){
            cout << grid[i][j] << " ";
        }
        cout << "\n";
    }
}