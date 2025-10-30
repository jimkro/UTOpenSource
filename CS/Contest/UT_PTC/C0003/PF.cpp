/*
    Solution:
    1. 注意到燈泡在被操作奇數次時會是亮著的,反之則關
    2. 試圖找因數有奇數個的整數n具有什麼特徵
    3. 舉例找規律
    Ex: 18 = 1 * 18 = 2 * 9 = 3 * 6, 兩兩一組共 6 個 => 關閉
        發現好似都會成對出現,又觀察到 1 = 1 * 1 雖是兩兩成對卻只有 1 個因數(1),
        所以可得到 "若 n 的相乘組合中包含了 x * x 就會使得因數數量呈現奇數,亦即燈泡亮著"
    4. 問題轉換為,給一個整數 n 求是否為完全平方數
*/
#include<bits/stdc++.h>
using namespace std;
#define ll long long

void solve(){
    while(1){
        ll n; cin >> n;
        if(n == 0) break;
        // 開根號取下限再平方,如果可以還原回去就代表他是完全平方數
        // Ex : 8 --sqrt--> 2 --pow(x,2)--> 4, 8 != 4, 8不是完全平方數
        if((ll)(pow((ll)sqrt(n),2)) == n){
            cout << "yes\n";
        }else{
            cout << "no\n";
        }
    }
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    solve();
    return 0;
}