#include<bits/stdc++.h>
using namespace std;
#define ll long long
vector<int> fkey(26); // 準備好 "MARGARITA" 所需要的字母數量

void init(){
    string s = "MARGARITA";
    for(char c : s) fkey[c-'A']++;
}

// 模擬法
void solve(){
    string s; cin >> s;
    vector<int> f(26); for(char c : s) f[c-'A']++;
    int cnt = 0;
    
    while(1){
        // 可以想成逐步兌換Pizza
        for(int i=0;i<26;i++){
            if(f[i] >= fkey[i]){ // 兌換
                f[i] -= fkey[i];
            }else{ // 字母不夠用了,結算Pizza!
                cout << cnt << "\n";
                return;
            }
        }
        // 又得到了一片
        cnt++;
    }
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    init();
    int T; cin >> T;
    while(T--) solve();
    return 0;
}