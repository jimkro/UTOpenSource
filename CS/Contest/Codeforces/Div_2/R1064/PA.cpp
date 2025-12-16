#include <bits/stdc++.h>
using namespace std;
using ll = long long;

void solve(){
    int n; cin >> n;
    string s; cin >> s;
    vector<int> f(26);
    for(char c : s){
        f[c-'a']++;
    }
    cout << n - f[s[n - 1] - 'a'] << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
    return 0;
}