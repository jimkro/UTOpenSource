#include <bits/stdc++.h>
#define int long long
using namespace std;
const int MAX = 100000001;
bitset<MAX> isPrime;

void init(){
    isPrime.set();
    isPrime[0] = 0;
    isPrime[1] = 0;
    int upper = sqrt(MAX) + 1;
    for(int i = 2; i <= upper; i++){
        if(isPrime[i]){
            for(int j = i * i; j < MAX; j += i){
                isPrime[j] = 0;
            }
        }
    }
}

signed main() {
    ios::sync_with_stdio(0);cin.tie(0);
    init();
    int x;
    while(cin >> x){
        if(x == 1){
            cout << "1 is not the sum of two primes!\n";
            continue;
        }

        if(x % 2 == 1){
            if(isPrime[x - 2]){
                cout << x << " is the sum of 2 and " << x - 2 << ".\n";
            }else{
                cout << x << " is not the sum of two primes!\n";
            }
        }else{
            int start = x / 2 - 1;
            bool getAns = false;
            for(int i = start; i >= 3; i--){
                if(isPrime[i] && isPrime[x - i]){
                    cout << x << " is the sum of " << i <<" and " << x - i << ".\n";
                    getAns = true;
                    break;
                }
                if(getAns) break;
            }
            if(!getAns){
                cout << x << " is not the sum of two primes!\n";   
            }
        }
    }
    return 0;
}