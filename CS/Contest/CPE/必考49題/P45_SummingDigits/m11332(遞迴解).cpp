#include<bits/stdc++.h>
using namespace std;

int f(int n){
    if (n < 10) return n;

    int sum = 0;
    while (n != 0){
        sum += n % 10;
        n /= 10;
    }
    return f(sum);
}

int main(){
    int n;
    while (cin >> n){
        if (n == 0) break;

        cout << f(n) << endl;
    }
}