#include <bits/stdc++.h>
using namespace std;
int n;
vector<int> dx = {1, 1, -1, -1, 2, 2, -2 , -2};
vector<int> dy = {2, -2, 2 , -2, 1, -1, 1, -1};

struct P{
    int x, y, step;
    P(){}
    P(int x, int y, int step) : x(x), y(y), step(step){}
};

bool valid(int x, int y){
    return 0 <= x && x < n && 0 <= y && y < n;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    vector<vector<int>> grid(n, vector<int>(n, INT_MAX));
    queue<P> q; q.push({0, 0, 0});
    while(!q.empty()){
        auto [x, y, step] = q.front(); q.pop();
        if(step >= grid[x][y]) continue;
        grid[x][y] = step;

        for(int i = 0; i < 8; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(valid(newX, newY) && step + 1 < grid[newX][newY]){
                q.push({newX, newY, step + 1});
            }
        }
    }

    // output
    for(auto& row : grid){
        for(int x : row){
            cout << x << " ";
        }
        cout << "\n";
    }
}