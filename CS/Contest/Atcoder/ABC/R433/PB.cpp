#include<bits/stdc++.h>
using namespace std;
#define int long long

void solve(){
    int n; cin >> n;
    vector<int> v(n+1); for(int i=1;i<=n;i++) cin >>v[i];
    vector<int> res(n + 1, -1);
    for(int i=2;i<=n;i++){
        for(int j=i; j>=1;j--){
            if(v[j] > v[i]){
                res[i] = j;
                break;
            }
        }
    }
    for(int i = 1; i <= n; i++){
        cout << res[i] << "\n";
    }
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    solve();
    return 0;
}