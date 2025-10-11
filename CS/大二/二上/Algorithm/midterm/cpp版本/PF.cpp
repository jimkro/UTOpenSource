#include <bits/stdc++.h>
using namespace std;

void dfs(int curr, vector<vector<int>>& adj,  vector<bool>& visited){
    if(curr > adj.size() - 1 || visited[curr]) return;
    cout << curr << " ";
    visited[curr] = true;
    sort(adj[curr].begin(), adj[curr].end(), greater<int>());
    for(int x : adj[curr]){
        if(x == 0) continue;
        if(!visited[x]) dfs(x,adj,visited);
    }
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int V,E;

    while(cin >> V >> E){
        if(V == 0 && E == 0) break;
        vector<vector<int>> adj(V+1,vector<int>(V+1));
        
        for(int i=0;i<E;i++){
            int v1,v2; cin >> v1 >> v2;
            adj[v1].push_back(v2);
            adj[v2].push_back(v1);
        }
        
        vector<bool> visited(V+1);

        dfs(1,adj,visited);

        cout << "\n";
    }
}