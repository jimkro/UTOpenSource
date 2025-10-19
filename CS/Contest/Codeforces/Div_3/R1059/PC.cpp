#include<bits/stdc++.h>
using namespace std;
using ll = long long;
void solve(){
    ll a, b; cin >> a >> b;

    // 0 步
    if(a == b){
        cout << "0\n";
        return;
    }

    // 1 步
    int _xor = a ^ b;
    if(_xor < a){
        cout << "1\n" << _xor << "\n";
        return;
    }
    
    
    int tmp = 1;
    while(tmp <= a) tmp <<= 1;
    tmp -= 1;

    // cout << "tmp = " << tmp << "\n";
    
    if(tmp < b){ // 無解
        cout << "-1\n";
    }else{
        int _xor1 = tmp ^ a;
        int _xor2 = tmp ^ b;

        cout << "2\n" << _xor1 << " " << _xor2 << "\n";
    }
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int t; cin >> t;
    while(t--) solve();
}