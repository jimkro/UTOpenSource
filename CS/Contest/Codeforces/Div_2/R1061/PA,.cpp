#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n; cin >> n;
    if(n <= 2){
        cout << "0\n";
        return;
    }else if(n <= 4){
        cout << "1\n";
        return;
    }

    cout << 1 + (n - 3) / 2 << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}