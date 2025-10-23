#include<bits/stdc++.h>
using namespace std;
#define ll long long

void solve(){
    while(1){
        ll n; cin >> n;
        if(n == 0) break;
        // 開根號取下限再平方,如果可以還原回去就代表他是完全平方數
        // Ex : 8 --sqrt--> 2 --pow(x,2)--> 4, 8 != 4, 8不是完全平方數
        if((ll)(pow((ll)sqrt(n),2)) == n){
            cout << "yes\n";
        }else{
            cout << "no\n";
        }
    }
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    solve();
    return 0;
}