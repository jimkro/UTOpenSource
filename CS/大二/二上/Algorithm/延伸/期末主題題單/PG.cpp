#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    bool first = true;
    while(T--){
        // 測資間空行
        if(!first) cout << "\n";
        else first = false;
        
        int N, CAP; cin >> N >> CAP;
        int box = 0;

        vector<int> v(N); for(auto& x : v) cin >> x;
        sort(v.begin(), v.end());

        // fit
        int l = 0, r = N - 1;
        while(l <= r){
            box++;
            if(v[l] + v[r] <= CAP) l++;
            r--;
        }

        // output
        cout << box << "\n";
    }
}