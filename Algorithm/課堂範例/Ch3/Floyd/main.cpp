#include <bits/stdc++.h>
using namespace std;

// 紀錄表格內的資訊
struct info{
    int cost = INT_MAX,from = -1;
    info(int cost,int from): cost(cost),from(from){}
};

int main(){
    int V,E; // V : 節點數, E : 邊數

    while(cin >> V >> E){
        // 同簡報上的cost陣列
        vector<vector<info>> graph(V,vector<info>(V,{INT_MAX,-1}));
        
        // 輸入 : 無向圖
        for(int i=0;i<E;i++){
            int v,u,cost; cin >> v >> u >> cost;
            graph[v][u].cost = cost;
            graph[u][v].cost = cost;
            graph[u][v].from = v;
            graph[v][u].from = u;
        }

        // 初始化 : 自己到自己的距離定為 0
        for(int i=0;i<V;i++){
            graph[i][i].cost = 0;
            graph[i][i].from = i;
        }

        // Floyd
        for(int k = 0; k < V; k++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){
                    // 有路不能走 所以跳過
                    if(graph[i][k].cost == INT_MAX || graph[k][j].cost == INT_MAX) continue;

                    // 找到更短的路徑
                    if(graph[i][j].cost > graph[i][k].cost + graph[k][j].cost){
                        graph[i][j].cost = graph[i][k].cost + graph[k][j].cost;
                        graph[i][j].from = k;
                    }
                }
            }
        }

        // 輸出 (如 Ch3-p38 表格)
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                cout << graph[i][j].cost << "/" << graph[i][j].from << " ";
            }
            cout << "\n";
        }
    }
}