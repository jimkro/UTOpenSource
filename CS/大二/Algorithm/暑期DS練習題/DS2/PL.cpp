#include <bits/stdc++.h>

using namespace std;

string s(int n){
    if(n == 0) return "1";
    string res = "";
    string str = s(n-1);
    int len = str.size();
    char curr = str[0];
    int cnt = 1;
    for(int i = 1; i < len; i++){
        if(str[i] == curr){
            cnt++;
        }else{
            res += to_string(cnt) + curr;
            curr = str[i];
            cnt = 1;
        }
    }
    res += to_string(cnt) + curr;
    return res;
}

int main() {
    int n;
    while (cin >> n) {
        if(n == -1) break;
        cout << s(n) << endl;
    }
    return 0;
}
