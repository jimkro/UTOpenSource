#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n, k; cin >> n >> k;
    string s; cin >> s;
    stack<pair<char,int>> stk; // {'x', cnt};
    for(char c : s){
        if(stk.empty()) stk.push({c,1});
        else{
            if(c == stk.top().first){
                stk.push({c,stk.top().second + 1});
            }else{
                stk.push({c,1});
            }
        }
        if(!stk.empty() && stk.top().second == k){
            int tmp = k;
            while(tmp--) stk.pop();
        }
    }
    string ans = "";
    while(!stk.empty()){
        ans = stk.top().first + ans;
        stk.pop();
    }

    cout << ans;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    solve();
}