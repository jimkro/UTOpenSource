#include <bits/stdc++.h>
using namespace std;

void solve(){
    int n; cin >> n;
    const int FULL = (1 << n) - 1;

    // 前兩個是基底(一定會有的)
    cout << FULL << " " << (FULL >> 1) << " ";

    // 生成後其餘的
    for(int left = 1; left <= n - 1; left++){ // 左段長度
        int right = n - left - 1; // 右段長度
        const int UPPER = 1 << left;
        for(int i = 0; i < UPPER; i++){ // i跑左半邊的數值
            int curr = i << (n - left); // 把左半邊移動到位
            curr += (1 << (right)) - 1; // 加上右半邊
            cout << curr << " ";
        }
    }
    
    cout << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}

/* ex : n = 5
// 5個
11111

// 4個
01111

// 3個
00111
10111

// 2個
00011
01011
10011
11011

解釋:
可以看成
左 + 中(0) + 右
00     0     11
01     0     11
10     0     11
11     0     11
1. 可以發現左邊就是從小到大(因為要字典序最小)
2. 右邊固定都是1為了保持一路&下來還會有2個1

// 1個
00001
00101
01001
01101
10001
10101
11001
11101

// 0
00000
*/