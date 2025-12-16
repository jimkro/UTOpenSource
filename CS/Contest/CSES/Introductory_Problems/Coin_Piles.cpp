#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--){
        int a, b; cin >> a >> b;
        if((a + b) % 3 != 0 || min(a, b) * 2 < max(a, b)) cout << "NO\n";
        else cout << "YES\n";
    }
}