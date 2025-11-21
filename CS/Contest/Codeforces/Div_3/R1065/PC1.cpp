#include<bits/stdc++.h>
using namespace std;
#define int long long

void solve(){
    int n; cin >> n;
    vector<int> a(n), b(n);
    int cntA = 0, cntB = 0, chanA = 0, chanB = 0;
    for(int i=0;i<n;i++){
        cin >> a[i];
        cntA += a[i];
    }
    for(int i=0;i<n;i++){
        cin >> b[i];
        cntB += b[i];
    }
    int canA = 0;
    for(int i=n - 1;i>=0;i--){
        if(a[i] != b[i]){
            if(i % 2 == 0){
                canA = 1;
            }else{
                canA = -1;
            }
            break;
        }
    }

    if(cntA % 2 == cntB % 2){
        cout << "Tie\n";
    }else if(canA == 1){
        cout << "Ajisai\n";
    }else if(canA == -1){
        cout << "Mai\n";
    }else{
        if(cntA % 2 > cntB % 2){
            cout << "Ajisai\n";
        }else{
            cout << "Mai\n";
        }
    }

    /*
    if(chanA == chanB){
        if(cntA % 2 > cntB % 2){
            cout << "Ajisai\n";
        }else{
            cout << "Mai\n";
        }
    }else if(chanA > chanB){
        cout << "Ajisai\n";
    }else{
        cout << "Mai\n";
    }*/
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
    return 0;
}