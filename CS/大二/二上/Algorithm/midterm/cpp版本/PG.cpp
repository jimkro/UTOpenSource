#include <bits/stdc++.h>
using namespace std;

int cnt(int n){
    int res = 1;
    while(n != 1){
        if(n % 2 == 0){
            n/=2;
        }else{
            n = 3 * n + 1;
        }
        res++;
    }
    return res;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int i,j;
    while(cin >> i >> j){
        int l = min(i,j);
        int r = max(i,j);
        int mx = 0;

        for(int k = l; k <= r; k++){
            mx = max(mx,cnt(k));
        }
        cout << i << " " << j << " " << mx << "\n";
    }
}