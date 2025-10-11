#include<bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int T; cin >> T;
    int n;

    while(T--){
        cin >> n;
        vector<int> stocks(n);
        for(int i = 0; i < n; i++) cin >> stocks[i];
        int l = 0;
        long long ans = 0;
        for(int r = 1; r < n; r++){
            if(stocks[r] <= stocks[r-1]){
                if(r-1 != l){
                    ans += stocks[r-1] - stocks[l];
                }
                l = r;
            }
        }
        if(n - 2 >= 0 && stocks[n-1] > stocks[n-2] && n-1 != l){
            ans += stocks[n-1] - stocks[l];
        }
        cout << ans << "\n";
    }
}