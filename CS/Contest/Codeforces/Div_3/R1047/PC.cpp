#include <bits/stdc++.h>
#define int long long
using namespace std;

void solve(){
    int aa, bb; cin >> aa >> bb;
    int a = aa, b = bb;
    if(a % 2 == 0 && b % 2 == 1){
        cout << "-1\n";
    }else if(b % 2 == 0){
        while(b % 2 == 0){
            a *= 2;
            b /= 2;
        }
        a /= 2;
        b *= 2;
        if(a % 2 == 1){
            cout << "-1\n";
        }else{
            a = aa, b = bb;
            cout << a * (b / 2) + 2 << "\n";
        }
        
    }else{
        int res = a * b + 1;
        cout << res << "\n";
    }
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}