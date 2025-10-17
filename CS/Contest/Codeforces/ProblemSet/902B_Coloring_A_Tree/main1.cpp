/*
    skill : dfs
*/
#include<bits/stdc++.h>
using namespace std;

int dfs(int curr, int myColor, vector<int>& targetColor, unordered_map<int,vector<int>> & adj){
    int sum = 0;

    // 如果我打算上的顏色和我的目標色不同，所以我需要多塗一次
    if(targetColor[curr] != myColor){
        sum++; // 多塗一次
        myColor = targetColor[curr]; // 對於我底下的子節點，我打算上的顏色變成我的目標色
    }
    
    // 遞迴處理我的子節點
    for(int x : adj[curr]){
        sum += dfs(x, myColor, targetColor, adj);
    }

    return sum;
}
int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    
    int V; cin >> V;
    unordered_map<int,vector<int>> adj; // root -> children
    vector<int> targetColor(V + 1); // 目標色

    // 建立樹狀結構
    for(int i = 2; i <= V; i++){
        int r; cin >> r;
        adj[r].push_back(i);
    }

    // 輸入目標色
    for(int i = 1; i <= V; i++){
        int c; cin >> c;
        targetColor[i] = c;
    }
    // 從 root 開始 dfs, root 預設顏色為 0 (為了和題目保證的顏色範圍不會衝突)
    int ans = dfs(1, 0, targetColor, adj);
    cout << ans;
}