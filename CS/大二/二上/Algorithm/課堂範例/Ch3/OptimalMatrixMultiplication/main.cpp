// 連續矩陣乘法 Optimal Matrix Multiplication
#include <bits/stdc++.h>
using namespace std;

// 定義每個格子要存的數值
struct Info{
    // val: 最小乘法次數, from: 最小乘法次數的分割點
    // 至於from有甚麼用處可以參照簡報 p53，可以用來還原最優解
    int val = 0, from = -1; 
    Info(){};
    Info(int v, int f) : val(v), from(f){};
};

int main(){
    int n; // 矩陣數量

    while(cin >> n){

        // 輸入矩陣的大小，即簡報 p45 的 d0,d1,d2...dn
        vector<int> d(n+1); 
        for(int i=0;i<=n;i++) cin >> d[i];

        // dp[l][r]: 代表從第 l 個矩陣乘到第 r 個矩陣的最小乘法次數
        vector<vector<Info>> dp(n+1,vector<Info>(n+1));

        // for(int i=1;i<=n;i++) dp[i][i].val = 0; // 初始化dp[i][i]，可寫可不寫，因為本來array元素初始就是0

        for(int gap = 1; gap <= n - 1; gap++){ // gap = r - l，表示區間長度
            for(int l = 1; l + gap <= n; l++){
                int r = l + gap;
                int mn = INT_MAX, mn_idx = -1;

                for(int m = l; m + 1 <= r; m++){
                    // 計算分割點 m 的乘法次數
                    int cost = dp[l][m].val + dp[m+1][r].val + d[l-1] * d[m] * d[r];
                    // 更新最小值
                    if(cost < mn){
                        mn = cost;
                        mn_idx = m;
                    }
                }

                // 更新 dp[l][r]
                dp[l][r].val = mn;
                dp[l][r].from = mn_idx;
            }
        }

        // 輸出 (這邊看起來很麻煩但不要緊張，我只是為了輸出比較方便看而已，格式可以不用太在意，只要知道dp[1][n].val就是答案就好)
        const int W = 10;
        cout << "DP 表格 (val/from) :\n";
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(j < i){
                    cout << setw(W) << " ";
                }else if(i == j){
                    cout << setw(W) << left << "0";
                }else{
                    string cell = to_string(dp[i][j].val) + "/" + to_string(dp[i][j].from);
                    cout << setw(W) << left << cell;
                }
            }
            cout << "\n";
        }
    }
}
