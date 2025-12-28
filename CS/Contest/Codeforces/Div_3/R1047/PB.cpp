#include <bits/stdc++.h>
#define int long long
using namespace std;

void solve(){
    int n; cin >> n;
    vector<int> arr(n);
    for(int i=0; i<n; i++){
        cin >> arr[i];
    }
    for(int i=0; i<n; i++){
        cout << (n-arr[i]+1) << " ";
    }
    cout << "\n";
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}