#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n; cin >> n;
    string a,b; cin >> a >> b;
    vector<int> f1(26);
    for(char c : a) f1[c-'a']++;
    for(char c : b) f1[c-'a']--;
    for(int x : f1){
        if(x != 0){
            cout << "NO\n";
            return;
        }
    }
    cout << "YES\n";
    
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}