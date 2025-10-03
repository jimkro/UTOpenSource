#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
    
    int V,E,DS;
    while(cin >> V >> E >> DS && (V != 0 || E !=0 || DS != 0)){
        vector<vector<int>> v(V,vector<int>(V,100));
        for(int i=0;i<V;i++){
            v[i][i] = 0; 
        }      

        for(int i=0;i<E;i++){
            int v1,v2,w;
            cin >> v1 >> v2 >> w;
            v[v1-1][v2-1] = w;
            v[v2-1][v1-1] = w;
        }

        if(DS == 0){
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    printf("%3d ",v[i][j]);
                }
                printf("\n");
            }
        }else{
            for(int i=0;i<V;i++){
                printf("%d ",i+1);
                for(int j=0;j<V;j++){
                    if(v[i][j] != 0 && v[i][j] != 100){
                        printf("%d %d ",j+1,v[i][j]);
                    }
                }
                printf("\n");
            }
        }
        printf("\n");
    }
    return 0;
}
