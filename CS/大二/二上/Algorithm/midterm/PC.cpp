#include <bits/stdc++.h>
using namespace std;

int main(){
    
    int V,E,DS;
    while(cin >> V >> E >> DS && !(V == 0 && E == 0 && DS == 0)){
        vector<vector<int>> adj(V+1,vector<int>(V+1,100));
        for(int i=0;i<=V;i++) adj[i][i] = 0;
        for(int i=0;i<E;i++){
            int v1,v2,w; cin >> v1 >> v2 >> w;
            adj[v1][v2] = w;
            adj[v2][v1] = w;
        }

        // 0
        
        if(DS == 0){
            for(int i=1;i<=V;i++){
                for(int j=1;j<=V;j++){
                    printf("%3d ",adj[i][j]);
                }
                cout << "\n";
            }
        }else{
            for(int i=1;i<=V;i++){
                cout << i << " ";
                for(int j=1;j<=V;j++){
                    if(adj[i][j] != 100 && adj[i][j] != 0){
                        cout << j << " " << adj[i][j] << " ";
                    }
                }
                cout << "\n";
            }
        }
        cout << "\n";
    }
}