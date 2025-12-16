#include <bits/stdc++.h>
using namespace std;
int n;

string itob(int x){
    string s = "";
    while(x != 0){
        s += to_string(x%2);
        x /= 2;
    }
    s.resize(n, '0');
    reverse(s.begin(), s.end());
    return s;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    const int LIMIT = 1 << n;
    for(int i = 0; i < LIMIT; i++){
        int grayCode = i ^ (i >> 1);
        cout << itob(grayCode) << "\n";
    }
}