/* 題目請見DS4 PD。以下為最陽春的 Union-Find 做法，沒有包含優化的 Rank 比較！*/
#include<iostream>
#include<vector>
#include<algorithm>
#include<unordered_set>
using namespace std;

/* 透過遞迴尋找節點 x 的老爹是誰。每一「群」的所有成員都應該要指向他們共同的那個老爹 */
int Find(int x, vector<int>& parent){
    if(parent[x] == x) return x;
    int p = Find(parent[x], parent);

    /* 下面這一行很關鍵！用來紀錄查詢結果，可以壓縮這一「群」的深度（原本可能是 A <- B <- C <- D，透過Find(D)得到結果A之後，把D原先記錄的老爹從C換成A
        這樣下次Find(D)時就不需要在從C開始找。因為D在上次的Find過後已經直接指向A) */
    parent[x] = p; 
    
    return p;
}

/* 這邊就只是很隨便的把「接收到的第一個節點」指向「接收到的第二個節點」。記得要用Find來找兩個節點各自的老爹，才能夠全家一起和樂融融的去當別人的兒紙(否則會只有自己搬過去) */
void Union(int x, int y, vector<int>& parent){
    parent[Find(x, parent)] = Find(y, parent);
    return;
}


int main(){
    int cases; cin>>cases;
    while(cases-->0){
        int V,E; cin>>V>>E;
        vector<int> parent(V+1);
        for(int i=1; i<=V; i++) parent[i] = i; // 在最開始，每個人都是自己的老爹（因為還沒進行任何的Union合併)
        
        // 建立鄰接表格，第一個位置先從 weight(權重) 是因為等等要sort，而我懶得寫自訂sort，所以讓預設用第一個元素排序
        vector<vector<int>> edges(E, vector<int>(3, -1));
        for(int i=0; i<E; i++){
            int v1,v2,w; cin>>v1>>v2>>w;
            edges[i][0] = w;
            edges[i][1] = v1;
            edges[i][2] = v2;
        }


        sort(edges.begin(), edges.end()); // 我們等等要打最貪，從最短的edge開始接，所以這邊要先sort

        long long res = 0;

        int curEdgeCount = 0; // 用來累計目前已經接好的邊數 （當連接的邊數達到 V-1 時，代表已經完成「把V個節點接起來」的任務了！
        int need = V-1; 
        int index = 0; // 用來標記下一條要檢測的 edge(邊)
        while(curEdgeCount < need){
            int w = edges[index][0];
            int v1 = edges[index][1];
            int v2 = edges[index][2];
            index++;
            
            if(Find(v1, parent) == Find(v2, parent)) continue; // 如果v1和v2的老爹相同，你就不能接起這條edge。否則會形成cycle!

            // 把 v1,v2 接起來，順便把目前已經接好的邊數+1條
            Union(v1, v2, parent);
            curEdgeCount++;
            res += w;
        }

        // 輸出結果
        cout<<res<<"\n";
    }
}