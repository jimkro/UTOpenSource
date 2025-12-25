#include <bits/stdc++.h>
using namespace std;

int cal(int n){
    int res = 1;
    while(n != 1){
        if(n % 2 == 0) n /= 2;
        else n = n * 3 + 1;
        res++;
    }
    return res;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    vector<int> dp(100000);

    int a, b;
    while(cin >> a >> b){
        int l = min(a, b);
        int r = max(a, b);
        int mx = 1;
        for(int i = l; i <= r; i++){
            if(dp[i] == 0){
                dp[i] = cal(i);
            }
            mx = max(mx, dp[i]);
        }
        cout << a << " " << b << " " << mx << "\n";
    }
}