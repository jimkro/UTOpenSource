// solve by binary search
#include <bits/stdc++.h>
using namespace std;
#define int long long

int getLen(int n){
    if(n == 0) return 1;
    string s = to_string(n);
    return s.size();
}

void solve(){
    int n, m; cin >> n >> m;
    vector<int> v(n);
    vector<vector<int>> rems(11);

    for(int i = 0; i < n; i++){
        cin >> v[i];
        int len = getLen(v[i]);
        rems[len].push_back(v[i] % m);
    }

    // sort 以便 binary search
    for(int len = 1; len <= 10; len++) sort(rems[len].begin(), rems[len].end());

    // 預先做好 pow10 的 mod
    vector<int> pow10(11);
    int p = 1;
    for(int i = 0; i <= 10; i++){
        pow10[i] = p;
        p = (p * 10) % m;
    }

    int res = 0;
    for(int i = 0; i < n; i++){ // 把每個當 f(x, y) 中的 x
        int rem_i = v[i] % m;
        for(int len = 1; len <= 10; len++){
            if(rems[len].empty()) continue;
            
            int curr = (rem_i * pow10[len]) % m;
            int target = (m - curr) % m; // 若 curr = 0 -> 要找餘數是 0 的

            // 用 binary search 找target數量
            auto low = lower_bound(rems[len].begin(), rems[len].end(), target);
            auto high = upper_bound(rems[len].begin(), rems[len].end(), target);
            res += (high - low);
        }
    }
    cout << res << "\n";
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    solve();
    return 0;
}