#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n; cin >> n;
    int neg = 0, cnt = 0;
    while(n--){
        int tmp; cin >> tmp;
        if(tmp == 0){
            cnt++;
        }else if(tmp == -1){
            neg++;
        }
    }
    if(neg % 2 == 1) cnt += 2;
    cout << cnt << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}