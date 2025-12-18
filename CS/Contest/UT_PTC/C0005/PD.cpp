// WA
#include <bits/stdc++.h>
#define int long long
using namespace std;

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int n;
    int cnt = 1;
    while(cin >> n){
        if(n == 0) break;
        int times = 0;
        vector<int> v(n); for(int i = 0; i < n; i++) cin >> v[i];
        for(int i = 1; i < n; i++){
            if(v[i] < v[i-1]) times++;
        }
        cout << "Case " << cnt++ << ": " << times << "\n";
    }
    return 0;
}