#include<bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    
    int T, n; cin >> T;

    while(cin >> n){
        vector<vector<int>> adj(n,vector<int>(n,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cin >> adj[i][j];
            }
        } 

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i == j) continue;
                    adj[i][j] = min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        vector<int> order(n);
        for(int i=0;i<n;i++) cin >> order[i];

        long long sum = 0;
        for(int x : order){
            for(int i=0;i<n;i++){
                sum += adj[x][i];
                adj[i][x] = 0;
            }
        }

        cout << sum << "\n";
    }
}