#include<bits/stdc++.h>
using namespace std;
#define int long long

void solve(){
    int n; cin >> n;
    if(n == 2){
        cout << "1\n";
        return;
    }
    if(n % 2 == 1){
        cout << "0\n";
    }else{
        cout << n / 4 + 1 << "\n";
    }
}


signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
    return 0;
}

/*
8
4 + 4
2 + 2 + 4
2 + 2 + 2 + 2
*/