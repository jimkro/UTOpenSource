#include <bits/stdc++.h>
// #define int long long
using namespace std;

void solve(){
    int n; cin >> n;
    vector<int> v(n); for(int& x : v) cin >> x;
    unordered_map<int,vector<int>> mp;
    for(int i = 0; i < n ; i++){
        mp[v[i]].push_back(i);
    }
    bool f = true;
    for(auto& [key, val] : mp){
        if(val.size() % key != 0){
            f = false;
            break;
        }
    }

    int id = 0;
    if(!f){
        cout << "-1\n";
    }else{
        for(auto& [key, arr] : mp){
            for(int i = 0; i < arr.size(); i += key){
                id++;
                for(int j = i; j < i + key; j++){
                    v[arr[j]] = id;
                }
            }
        }

        for(int x : v) cout << x << " ";
        cout << "\n";
    }
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}