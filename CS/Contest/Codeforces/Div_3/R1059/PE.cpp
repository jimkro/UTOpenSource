#include<bits/stdc++.h>
using namespace std;
using ll = long long;

void solve(){
    int n, k; cin >> n >> k;
    vector<int> A(n); for(int i=0;i<n;i++) cin >> A[i];
    
    int n1 = A[n-2], n2 = A[n-1];

    for(int i=0;i<k;i++){
        for(int j = 1; j <= n;j++){
            if(j != n1 && j != n2){
                n1 = n2;
                n2 = j;
                cout << j << " ";
                break;
            }
        }
    }
    cout << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int t; cin >> t;

    while(t--) solve();
}   