#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int n;
    while(cin >> n, n){
        vector<int> v(n); for(int& x : v) cin >> x >> x;
        nth_element(v.begin(),v.begin() + (v.size() - 1) / 2, v.end());    
        int mid = v[(n - 1) / 2];
        long long res = 0;
        for(int x : v){
            res += abs(x - mid);
        }
        cout << mid << " " << res << "\n";
    }
    
}
