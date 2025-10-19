#include<bits/stdc++.h>
using namespace std;

void solve(){
    string line; cin >> line;
    
    for(int i=1;i<line.size();i++){
        if(line[i-1] == line[i]){
            cout << "1\n";
            return;
        }
    }
    cout << line.size() << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int t; cin >> t;
    while(t--) solve();
}