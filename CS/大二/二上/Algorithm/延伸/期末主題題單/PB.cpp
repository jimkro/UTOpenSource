#include <bits/stdc++.h>
using namespace std;

int N, E;
vector<vector<int>> adj;
vector<int> colors;

bool solve(){
    queue<int> q;
    for(int i = 0; i < N; i++){ // 避免有多個 components
        if(colors[i] != 0) continue; // 著色過了就跳過，去找下個 component

        q.push(i);
        while(!q.empty()){
            int cur = q.front(); q.pop();
            if(colors[cur] == 0) colors[cur] = 1; // 沒著色就預設是 1,為了最初的節點用的
            
            int otherColor = 3 - colors[cur];
            for(int next : adj[cur]){
                if(colors[next] == 0){
                    colors[next] = otherColor;
                    q.push(next);
                }else if(colors[next] == colors[cur]) return false;
            }
        }
    }
    
    return true;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    
    while(cin >> N, N){
        cin >> E;
        adj.assign(N, vector<int>());
        colors.assign(N, 0);
        
        // input edges
        for(int i = 0; i < E; i++){
            int u, v; cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        // output
        if(solve())cout << "BICOLORABLE.\n";
        else cout << "NOT BICOLORABLE.\n";
    }
}