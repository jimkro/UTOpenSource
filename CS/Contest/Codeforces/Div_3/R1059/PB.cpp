#include<bits/stdc++.h>
using namespace std;
using ll = long long;

void solve(){
    int n; cin >> n;
    string s; cin >> s;
    vector<int> ans;
    for(int i=1;i<=n;i++){
        if(s[i-1] == '0'){
            ans.push_back(i);
        }
    }

    cout << ans.size() << "\n";
    for(int x : ans){
        cout << x << " ";
    }

    cout << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int t; cin >> t;
    while(t--) solve();
}