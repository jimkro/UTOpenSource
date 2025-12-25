#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    long long n;
    int first = true;
    while(cin >> n){
        if(first) first = false;
        else cout << "\n";
        long long tmp = n % 7;
        int t = 1;
        if(tmp == 0){
            t = 1;
        }else if(tmp % 2 == 0){
            t = 3;
        }else{
            t = 2;
        }

        while(t--){
            cout << "Hello World!\n";
        }
    }
}