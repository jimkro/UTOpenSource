#include <bits/stdc++.h>
using namespace std;

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
        queue<int> q;
        vector<bool> vis(V+1,false);
        q.push(1);
        while(!q.empty()){
            int curr = q.front(); q.pop();
            if(vis[curr]) continue;
            vis[curr] = true;
            cout << curr << " ";
            sort(adj[curr].begin(),adj[curr].end());

            for(int x : adj[curr]){
                if(x == 0) continue;
                if(!vis[x]){
                    q.push(x);
                }
            }
        }
        cout << "\n";
    }
}