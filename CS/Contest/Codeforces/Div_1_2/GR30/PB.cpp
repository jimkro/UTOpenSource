#include<bits/stdc++.h>
using namespace std;
using ll = long long;

bool check(int x, int y){
    return (y % x) % 2 == 0;
}

void solve(){
    int n; cin >> n;
    vector<int> v(n); for(int i=0;i<n;i++) cin >> v[i];
    
    for(int j = 1; j < n; j++){
        for(int i = 0; i < j; i++){
            if(check(v[i], v[j])){
                cout << v[i] << " " << v[j] << "\n";
                return;
            }
        }
    }

    cout << "-1\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}