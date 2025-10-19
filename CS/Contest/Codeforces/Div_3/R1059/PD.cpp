#include<bits/stdc++.h>
using namespace std;
using ll = long long;

void solve(){
    int n; cin >> n;
    int l = 1, r = n;
    int ll = -1;
    int len;
    int sum1, sum2;

    // 先鎖定被修改的子陣列長度
    // ori
    cout << "1 " << 1 << " " << n << endl;
    cin >> sum1;

    // modi
    cout << "2 " << 1 << " " << n << endl;
    cin >> sum2;

    len = sum2 - sum1;

    while(l <= r){
        int m = l + (r - l) / 2;
        
        // ori
        cout << "1 " << l << " " << m << endl;
        cin >> sum1;

        // modi
        cout << "2 " << l << " " << m << endl;
        cin >> sum2;

        int gap = sum2 - sum1;
        if(gap == 0){
            l = m + 1;
        }else if(gap < len){
            ll = m - gap + 1;
            break;
        }else if(gap == len){
            r = m - 1;
        }
    }

    if(ll == -1) ll = l;

    cout << "! " << ll << " " << (ll + len - 1) << endl;
}

int main(){
    // ios::sync_with_stdio(0); cin.tie(0);
    int t; cin >> t;
    while(t--) solve();
}