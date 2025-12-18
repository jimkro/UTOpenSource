#include<bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0); cin.tie(0);

    int T; cin >> T;

    while(T--){
        int n, m; cin >> n >> m;
        vector<int> v(n+1);

        for(int i=0;i<m;i++){
            int a,b; cin >> a >> b;
            v[a]++;
            v[b]++;
        }
        
        for(int i=1;i<=n;i++){
            cout << i << " " << v[i] << "\n";
        }
    }
}