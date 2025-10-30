#include<bits/stdc++.h>
using namespace std;
#define ll long long

// 用雙指針檢查迴文
bool isPalindrome(const string& s){
    int l = 0, r = s.size() - 1;
    while(l < r){
        if(s[l] != s[r]) return false;
        l++;
        r--;
    }
    return true;
}
// 翻轉 + 相加
void R_and_A(string& s){
    ll s_ori = stoll(s);
    reverse(s.begin(),s.end());
    ll s_reversed = stoll(s);
    s = to_string(s_ori + s_reversed);
}

void solve() {
    string s; cin >> s;
    int cnt = 0;
    
    while(1){
        // 是迴文表示找到了
        if(isPalindrome(s)){
            cout << cnt << " " << s << "\n";
            return;
        }
        cnt++;
        
        // 操作後進下一輪
        R_and_A(s);
    }
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);

    int N; cin >> N;
    while(N--) solve();

    return 0;
}