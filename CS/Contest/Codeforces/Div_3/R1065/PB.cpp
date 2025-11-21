#include<bits/stdc++.h>
using namespace std;
#define int long long

void solve(){
    int n; cin >> n;
    vector<int> v(n); for(int i=0;i<n;i++) cin >> v[i];
    int res = 0;
    if(v[0] == -1 && v[n - 1] == -1){
        v[0] = 0;
        v[n-1] = 0;
    }else{
        if(v[0] == -1){
            v[0] = v[n-1];
        }else if(v[n-1] == -1){
            v[n-1] = v[0];
        }
    }

    cout << abs(v[0] - v[n-1]) << "\n";
    for(int i=0;i<n;i++){
        if(v[i] == -1) v[i] = 0;
        cout << v[i] << " ";
    }

    cout << "\n";
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
    return 0;
}
