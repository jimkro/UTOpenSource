/*
解題想法
參考https://gdst.dev/posts/UVA-10093/ 的數學邏輯
*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    string s;
    int big, t, ans;
    long long sum;
    bool f;

    while (getline(cin, s)){
        if (s.empty()) continue;
        sum = 0;
        big = 1;
        f = 0;

        for(char c : s){
            if (c >= '0' && c <= '9'){
                t = c-'0';
            }else if (c >= 'A' && c <= 'Z'){
                t = c - 'A' + 10;
            }else if (c >= 'a' && c <= 'z'){
                t = c - 'a' + 36;
            }else continue;
            
            sum += t;
            big = max(t, big);
        }

        for (int i = big; i <= 62; i++){
            if (sum % i == 0) {
                ans = i+1;
                f = 1;
                break;
            }
        }

        if (f) cout << ans << "\n";
        else cout << "such number is impossible!\n";
    }
}
