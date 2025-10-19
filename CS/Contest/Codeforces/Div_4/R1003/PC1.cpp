#include<bits/stdc++.h>
using namespace std;

int change(int a, int b){
    return b - a;
}

void solve(){
    int n, m; cin >> n >> m;
    vector<int> a(n + 1); for(int i=1;i<=n;i++) cin >> a[i];
    int b; cin >> b;
    a[0] = INT_MIN;

    for(int i = 1; i <= n ;i++){
        int c = change(a[i],b);
        if(a[i - 1] > a[i]){
            if(a[i-1] > c){
                cout << "NO\n";
                return;
            }else{
                a[i] = c;
            }
        }else{
            if(c < a[i] && c >= a[i-1]){
                a[i] = c;
            }
        }
    }
    cout << "YES\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int t; cin >> t;
    while(t--) solve();
}