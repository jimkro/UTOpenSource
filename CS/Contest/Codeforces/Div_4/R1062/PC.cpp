#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n; cin >> n;
    vector<int> v(n);
    bool hasOdd = false;
    bool hasEven = false;

    for(int i=0;i<n;i++){
        cin >> v[i];
        if(v[i] % 2 == 1){
            hasOdd = true;
        }else{
            hasEven = true;
        }
    }
    if(hasOdd && hasEven){
        sort(v.begin(), v.end());
    }

    for(int x : v) cout << x << " ";
    cout << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}