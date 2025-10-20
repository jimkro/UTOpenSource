// title : Coloring a Tree
#include<bits/stdc++.h>
using namespace std;

int dfs(int curr, int newColor, vector<int>& targetColor, unordered_map<int,vector<int>> & adj){
    int sum = 0;
    if(targetColor[curr] != newColor){
        sum++;
        newColor = targetColor[curr];
    }
    
    for(int x : adj[curr]){
        sum += dfs(x, newColor, targetColor, adj);
    }

    return sum;
}
int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    
    int V; cin >> V;
    unordered_map<int,vector<int>> adj;
    vector<int> targetColor(V + 1);

    for(int i = 2; i <= V; i++){
        int r; cin >> r;
        adj[r].push_back(i);
    }

    for(int i = 1; i <= V; i++){
        int c; cin >> c;
        targetColor[i] = c;
    }
    int ans = dfs(1, 0, targetColor, adj);
    cout << ans;
}