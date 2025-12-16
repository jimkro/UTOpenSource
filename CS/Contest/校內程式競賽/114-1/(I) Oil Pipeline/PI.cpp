// WA
#include <bits/stdc++.h>
using namespace std;
#define int long long
int n; 

void solve(){
    vector<int> v(n);
    for(int i=0;i<n;i++) cin >> v[i] >> v[i]; // 因為 x 用不到就直接蓋過
    sort(v.begin(), v.end());
    
    // 雖然直接 n / 2都可取到適當的中位數, 但說若有多個解輸出最小的
    int d = n % 2 == 0 ? 1 : 0;
    int mid = v[n / 2 - d];

    int res = 0;
    for(int x : v) res += abs(mid - x);

    cout << mid << " " << res << "\n";
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    while(cin >> n && n != 0) solve();
}