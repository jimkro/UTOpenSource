// AC
#include<bits/stdc++.h>
using namespace std;

void solve(){
    string s; cin >> s;
    int n = s.size();

    bool inf = false;
    for(int i = 0; i < n - 1; ++i){
        char c1 = s[i];
        char c2 = s[i+1];
        if(c1 == '*' && c2 == '*') inf = true;
        if(c1 == '>' && c2 == '<') inf = true;
        if(c1 == '>' && c2 == '*') inf = true;
        if(c1 == '*' && c2 == '<') inf = true;
        if(inf) break;
    }

    if(inf){
        cout << "-1\n";
        return;
    }

    int cnt1 = 0;
    int currL = 0;
    for(int i = 0; i < n; ++i){
        if(s[i] == '>'){
            currL = 0;
        }else{
            currL++;
            cnt1 = max(cnt1, currL);
        }
    }

    int cnt2 = 0;
    int currR = 0;
    for(int i = 0; i < n; ++i){
        if(s[i] == '<'){
            currR = 0;
        }else{
            currR++;
            cnt2 = max(cnt2, currR);
        }
    }
    
    cout << max(cnt1, cnt2) << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}