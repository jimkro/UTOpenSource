#include<bits/stdc++.h>
using namespace std;

int degree(int n){
    if (n < 10) return 0;
    int tmp = 0, ans = 1;

    while (n != 0){
        tmp += n % 10;
        n /= 10;
    }
    if (tmp % 9 != 0 || tmp < 10){
        return ans;
    }else {
        ans += degree(tmp);
    }
    return ans;
}

int main(){
    int n, ans;
    string s;

    while (cin >> s){
        if (s == "0") break;
        ans = 0;
        n = 0;

        for (char c : s){
            n += c - '0';
        }
        if (n % 9 != 0){
            cout << s << " is not a multiple of 9.\n";
            continue;
        }
        ans++;
        ans += degree(n);

        cout << s << " is a multiple of 9 and has 9-degree " << ans << ".\n";
    }
}