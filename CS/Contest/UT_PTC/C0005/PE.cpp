#include <bits/stdc++.h>
#define int long long
using namespace std;

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int n;
    while(cin >> n){
        if(n == 0) break;
        unordered_map<int,int> mp;
        while(n--){
            int a, b; cin >> a >> b;
            mp[a]++;
            mp[b]--;
        }
        bool res = true;
        for(auto& p : mp){
            if(p.second != 0){
                res = false;
                break;
            }
        }

        if(res) cout << "YES\n";
        else cout << "NO\n";
    }
    return 0;
}