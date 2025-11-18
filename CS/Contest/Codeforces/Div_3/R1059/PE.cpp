// upsolving AC
#include<bits/stdc++.h>
using namespace std;
using ll = long long;

void solve(){
    int n, k; cin >> n >> k;
    vector<int> v(n);
    vector<int> cnt(n + 1);
    for(int i=0;i<n;i++){
        cin >> v[i];
        cnt[v[i]]++;
    }

    int x = -1;
    for(int i=1;i<=n;i++){
        if(cnt[i] == 0){
            x = i;
            break;
        }
    }

    //三個一循環
    if(x == -1){ // 是 permutation
        for(int i=0;i<k;i++) cout << v[n - 3 + (i % 3)] << " "; 
    }else{ // 不是 permutation
        int y = -1;
        for(int i=1;i<=n;i++){
            if(i != x && i != v[n - 1]){
                y = i;
                break;
            }
        }
        vector<int> cir = {x, y, v[n - 1]};
        for(int i=0;i<k;i++) cout << cir[i % 3] << " ";
    }
    cout << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}   