/* Solution
    1. 可以觀察到,當我們把a1 a2 a3...依序填上1 2 3...時總和為 0,又

*/
#include<bits/stdc++.h>
using namespace std;

const int MOD = 1000000007;
const int MAX_K = 500000;
long long factorial[MAX_K];

void precompute_factorials(){
    factorial[0] = 1;
    for(int i = 1; i <= MAX_K; ++i){
        factorial[i] = (factorial[i - 1] * i) % MOD;
    }
}

int main(){
    
    ios_base::sync_with_stdio(0); cin.tie(0);

    precompute_factorials();

    int n;

    while(cin >> n){
        long long ans;
        if(n % 2 == 0){
            int k = n / 2;
            long long term = factorial[k];
            ans = (term * term) % MOD;
        }else{
            int k = (n - 1) / 2;
            long long term = factorial[k];
            ans = (term * term) % MOD;
            ans = (ans * (long long)(n % MOD)) % MOD;
        }

        cout << ans << "\n";
    }

    return 0;
}