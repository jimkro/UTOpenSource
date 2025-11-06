#include<bits/stdc++.h>
using namespace std;
using ll = long long;

void solve(){
    int n; cin >> n;
    vector<int> v(n); for(int i=0;i<n;i++) cin >> v[i];
    int x; cin >> x;
    if(n == 1){
        if(v[0] == x) cout << "YES\n";
        else cout << "NO\n";
        return;
    }

    for(int i=1;i<n;i++){
        if(min(v[i],v[i-1]) <= x && x <= max(v[i],v[i-1])){
            cout << "YES\n";
            return;
        }
    }
    cout << "NO\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}