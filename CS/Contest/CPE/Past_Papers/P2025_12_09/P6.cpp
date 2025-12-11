// Uva 11806 Cheerleaders : AC
#include <bits/stdc++.h>
#define ll long long
using namespace std;
const int MOD = 1e6 + 7;
vector<vector<ll>> C(401, vector<ll>(401, 0));

// 初始化組合數
void initC(){
    for(int i = 0; i <= 400; i++) C[i][0] = C[i][i] = 1;
    for(int i = 2; i <= 400; i++){
        for(int j = 1; j < i; j++){
            C[i][j] = (C[i-1][j] + C[i-1][j-1]) % MOD;
        }
    }
}

void solve(){
    int m, n, k; cin >> m >> n >> k;
    int tot = m * n;
    if(k > tot){
        cout << 0;
        return;
    }

    // 排容
    ll res = C[tot][k]; // 全部

    // 刪去1條
    res -= C[tot - n][k] * 2; // 不含 上, 下
    res -= C[tot - m][k] * 2; // 不含 左, 右

    // 刪去兩條
    res += C[tot - n*2][k]; // 不含 上下
    res += C[tot - m*2][k]; // 不含 左右
    res += C[tot - m - n + 1][k] * 4; // 不含 上左, 上右, 下左, 下右

    // 刪去三條
    res -= C[tot - n*2 - m + 2][k] * 2; // 不含 上下左, 上下右
    res -= C[tot - m*2 - n + 2][k] * 2; // 不含 上左右, 下左右

    // 刪去四條
    res += C[tot - m*2 - n*2 + 4][k]; // 不含 上下左右

    // MOD
    res %= MOD;
    if(res < 0) res += MOD;
    cout << res; 
}

int main(){
    ios::sync_with_stdio(0);
    int T; cin >> T;
    initC();
    for(int t = 1; t <= T; t++){
        cout << "Case " << t << ": ";
        solve();
        cout << "\n";
    }
}