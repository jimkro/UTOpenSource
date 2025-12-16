// AC
#include <bits/stdc++.h>
using namespace std;
#define int long long

void solve(){
    int n; cin >> n;
    vector<int> v(n); for(int i=0;i<n;i++) cin >> v[i];
    int res = 0;
    for(int i = 0; i < n; i++){
        bool swapped = false;
        for(int j = 1; j < n; j++){
            if(v[j-1] > v[j]){
                swap(v[j-1], v[j]);
                swapped = true;
                res++;
            }
        }
        if(!swapped) break;
    }
    cout << res << "\n";
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;

    while(T--) solve();
}