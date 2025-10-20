#include<bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    long long n, m;
    while(cin >> n >> m){
        long long nn = n;
        bool f = true;
        
        if(n == 0 || m == 0 || n < m || m == 1 || (__gcd(m,n) == 1)){
            cout << "Boring!\n";
            continue;
        }

        
        while(n != 1){
            if(n % m != 0){
                f = false;
                cout << "Boring!\n";
                break;
            }
            n /= m;
        }


        if(!f) continue;

        while(nn != 1){
            cout << nn << " ";
            nn /= m;
        }
        
        cout << "1\n";
    }
}