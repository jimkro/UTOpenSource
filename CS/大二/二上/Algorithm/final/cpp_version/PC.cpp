#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int n;
    vector<long long> f(91);
    f[1] = 1;
    f[2] = 2;
    for(int i = 3; i <= 90; i++){
        f[i] = f[i-1] + f[i-2];
    }
    while(cin >> n, n){
        cout << f[n] << "\n";
    }
}