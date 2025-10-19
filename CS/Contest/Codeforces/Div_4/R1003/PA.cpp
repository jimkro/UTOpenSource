#include<bits/stdc++.h>
using namespace std;

void solve(){
    string line; cin >> line;

    line.resize(line.size() - 2);
    line.push_back('i');
    
    cout << line << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int t; cin >> t;
    while(t--) solve();
}