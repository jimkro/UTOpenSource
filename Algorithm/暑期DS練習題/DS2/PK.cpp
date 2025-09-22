#include <bits/stdc++.h>

using namespace std;

int f(int n){
    int res = 0;
    while(n != 1){
        if(n % 2 == 0){
            n /= 2;
        }else{
            n = (n * 3 + 1);
        }
        res++;
    }
    return res + 1;
}

int main() {
    int n;
    while (cin >> n) {
        if(n == 0) break;
        cout << f(n) << endl;
    }
    return 0;
}
