#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n; cin >> n;
    vector<int> v(n+1); for(int i=1;i<=n;i++) cin >> v[i];
    sort(v.begin(), v.end());
    int cnt = 0;
    int target = (n - 1) / 2;
    for(int i = 2; i < n; i+=2){
        if(v[i] == v[i + 1]) cnt++;
    }
    if(cnt >= target) cout << "YES\n";
    else cout << "NO\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}