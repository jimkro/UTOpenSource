#include<bits/stdc++.h>
using namespace std;
#define int long long
vector<int> a, b, da, db;

void update(bool isA, int val){
    int idx = 31;
    if(isA){
        while(val != 0){
            da[idx--] += val & 1;
            val >>= 1;
        }
    }else{
        while(val != 0){
            db[idx--] += val & 1;
            val >>= 1;
        }
    }
}

void solve(){
    int n; cin >> n;
    a.assign(n, 0); for(int i = 0; i < n; i++) cin >> a[i];
    b.assign(n, 0); for(int i = 0; i < n; i++) cin >> b[i];
    da.assign(32,0);
    db.assign(32,0);
    for(int i=0;i<n;i++){
        int tmp = a[i] ^ b[i];
        update(i % 2 == 0, tmp);
    }
    int res = 0;
    for(int i = 0; i < 32; i++){
        if(da[i] != 0 || db[i] != 0){
            if(da[i] > db[i]){
                res = 1;
            }else if(da[i] < db[i]){
                res = -1;
            }
            break;
        }
        
    }
    // for(int x : da) cout << x << " ";
    // cout << "\n";
    // for(int x : db) cout << x << " ";
    // cout << "\n";
    if(res == 1){
        cout << "Ajisai\n";
    }else if(res == -1){
        cout << "Mai\n";
    }else{
        int valA = 0, valB = 0;
        for(int x : a) valA ^= x;
        for(int x : b) valB ^= x;
        if(valA == valB){
            cout << "Tie\n";
        }else if(valA > valB){
            cout << "Ajisai\n";
        }else{
            cout << "Mai\n";
        }
    }
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
    return 0;
}