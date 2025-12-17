// AC
#include <bits/stdc++.h>
#define int long long
using namespace std;
vector<bool> isPrime;
void init(){
    vector<int> primes;
    isPrime.assign(100000000+1, true);
    isPrime[0] = isPrime[1] = false;
    for(int i = 2; i <= 100000000; i++){
        if(isPrime[i]) primes.push_back(i);
        for(int p : primes){
            if((long long)i * p > 100000000) break;
            isPrime[i*p] = false;
            if(i % p == 0) break;
        }
    }
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int n;
    init();
    while(cin >> n){
        if(n == 1){
            cout << "1 is not the sum of two primes!\n";
            continue;
        }

        if(n % 2 == 1){
            if(isPrime[n-2]){
                cout << n << " is the sum of 2 and " << n-2 << ".\n";
            }else{
                cout << n << " is not the sum of two primes!\n";
            }
        }else{
            int resX = -1, resY = -1;
            int l = n / 2 - 1, r = n / 2 + 1;
            while(l > 1 && r <= n - 1){
                if(isPrime[l] && isPrime[r] ){
                    resX = l;
                    resY = r;
                    break;
                }
                l--;
                r++;
            }
            if(resX == -1 && resY == -1){
                cout << n << " is not the sum of two primes!\n";
            }else{
                cout << n << " is the sum of " << resX << " and " << resY << ".\n";
            }
        }
    }
    return 0;
}