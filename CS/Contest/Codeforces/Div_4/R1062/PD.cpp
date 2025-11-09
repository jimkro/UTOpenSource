#include<bits/stdc++.h>
using namespace std;
using ll = long long;

ll gcd(ll a, ll b){
    return b == 0 ? a : b % a;
}

ll check(ll mn, ll x){
    for(int i = 3; i < mn; i++){
        if(gcd(i,x) == 1){
            return i;
        }
    }
    return x + 1;
}

void solve(){
    int n; cin >> n;
    ll mn = LLONG_MAX;
    bool f = false;
    for(int i=0;i<n;i++){
        ll tmp; cin >> tmp;
        // 特解
        if(tmp % 2 == 1){
            mn = 2;
            f = true;
        }
        if(!f){
            mn = min(mn, tmp + 1);
            if(tmp != 2) mn = min(mn, tmp - 1);
            mn = min(mn, check(mn, tmp));
        }
    }
    
    if(mn == LLONG_MAX){
        cout << "-1\n";
    }else{
        cout << mn << "\n";
    }
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}