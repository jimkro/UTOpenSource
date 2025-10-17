#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n, k; cin >> n >> k;
    k = 240 - k;

    int l = 0, r = n;
    
    while(l <= r){
        int m = l + (r - l) / 2;
        int sum = 5 * (1 + m) * m / 2;
        
        if(sum == k){
            cout << m;
            return;
        }else if(sum > k){
            r = m - 1;
        }else{
            l = m + 1;
        }
    }
    cout << r;
    return;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    solve();
}