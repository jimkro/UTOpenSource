#include<bits/stdc++.h>
using namespace std;

void solve(){
    int N, M; cin >> N >> M;
    if(N == 1){
        int n;
        cin >> n;
        while(M--){
            int idx, div; cin >> idx >> div;
            n /= div;
            cout << n << "\n";
        }
        return;
    }
    vector<int> v(N + 1); for(int i=1;i<=N;i++) cin >> v[i];
    int val_gcd = __gcd(v[1],v[2]);
    for(int i = 3; i <= N; i++){
        val_gcd = __gcd(val_gcd,v[i]);
    }

    while(M--){
        int idx, div; cin >> idx >> div;
        v[idx] /= div;
        val_gcd = __gcd(val_gcd, v[idx]);
        cout << val_gcd << "\n";
    }


}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    solve();
}