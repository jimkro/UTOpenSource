#include<bits/stdc++.h>
using namespace std;
#define int long long

void solve(){
    int a, b, times; cin >> a >> b >> times;
    if(b > a){
        cout << "No\n";
        return;
    }

    while(b * times <= a){
        if(b * times == a){
            cout << "Yes\n";
            return;
        }
        b++;
        a++;
    }
    cout << "No\n";
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    solve();
    return 0;
}

/*
a + x = ;
a = times(b + x) - x
a/t = b + x - x / t

*/