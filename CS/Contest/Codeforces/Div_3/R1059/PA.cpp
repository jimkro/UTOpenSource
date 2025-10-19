#include<bits/stdc++.h>
using namespace std;
using ll = long long;

void solve(){
    int n; cin >> n;
    int mx = 0;
    for(int i=0;i<n;i++){
        int tmp; cin >> tmp;
        mx = max(mx,tmp);
    }
    cout << mx << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int t; cin >> t;
    while(t--) solve();
}