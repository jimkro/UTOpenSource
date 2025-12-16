#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    string s; cin >> s;
    char mid = '?';
    string res = "";
    vector<int> f(26);
    for(char c : s) f[c-'A']++;
    for(int i = 0; i < 26; i++){
        if(f[i] % 2 == 1){
            if(mid == '?'){
                mid = (char)(i + 'A');
            }else{
                res = "NO SOLUTION";
                break;
            }
        }
    }
    if(res.empty()){
        if(mid != '?') res += mid;
        for(int i = 0; i < 26; i++){
            if(f[i] % 2 == 1) f[i]--;
            string tmp(f[i] / 2, (char)(i + 'A'));
            res = tmp + res + tmp;
        }
    }
    cout << res << "\n";
}