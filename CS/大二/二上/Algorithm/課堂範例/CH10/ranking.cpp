#include <bits/stdc++.h>
#define int long long
using namespace std;

int n;
int solve(){
    // if(n == 0) return 0;

    int res = 0;
    int cur = 0;
    while(cur < n){
        cur = cur * 2 + 1;
        res++;
    }
    return res;
}

int cal(int p){
    return pow(2, p) - 1;
}

int solveByMath(){
    // if(n == 0) return 0;
    int l = 0, r = n;

    while(l <= r){
        int m = l + (r - l) / 2;

        if(n > cal(m))l = m + 1;
        else r = m - 1;
    }
    return l;
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);

    
    while(cin >> n){
        int res = solveByMath();
        cout << res << "\n";
    }
}