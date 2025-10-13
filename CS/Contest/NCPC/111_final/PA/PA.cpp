#include<bits/stdc++.h>
using namespace std;

void solve(int n){
    unordered_map<int,int> mp; // val -> idx
    int idx = 1;

    while(1){
        // 出現過表示找到循環了
        if(mp.count(n)){
            cout << (idx - mp[n]) << "\n";
            break;
        }

        // 紀錄idx
        mp[n] = idx++;
        
        // 計算 
        int sum = 0;
        while(n != 0){
            sum += (int)pow((n%10),2);
            n /= 10;
        }

        // 迭代
        n = sum;
    }

}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;

    while(T--){
        int n; cin >> n;
        solve(n);
    }
}