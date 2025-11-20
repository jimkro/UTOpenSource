#include<bits/stdc++.h>
using namespace std;
using ll = long long;
int len;
vector<ll> s;
vector<ll> v;
string res = "";

// 解左右沒括號的
void recurr(string str){
    // base case : 初始化 s
    bool base = true;
    for(char c : str){
        if(c == '+' || c == '*'){
            base = false;
            break;
        }
    }
    if(base){ // 沒括號
        fill(s.begin(), s.end(), stoll(str));
        return;
    }

    // recurr
    int start = find(str.begin(), str.end(), '[') - str.begin() + 1;
    recurr(str.substr(start, (int)str.size() - start - 1));

    // do smth
    int opIdx = 0;
    char op; // 找 運算子
    for(int i=0;i<str.size();i++){
        char c = str[i];
        if(c == '+' || c == '*'){
            opIdx = i;
            op = c;
            break;
        }
    }

    // update
    ll m = stoll(str.substr(0, opIdx));
    fill(v.begin(), v.end(), 0);

    if(op == '+'){
        v[0] = m; // init
        for(int i = 1; i < len; i++){
            v[i] = v[i - 1] + s[i - 1];
        }
    }else{
        v[0] = m * s[0]; // init
        for(int i = 1; i < len; i++){
            v[i] = v[i - 1] * s[i];
        }
    }

    // swap
    swap(s, v);
}

void solve(string str){
    str = str.substr(1, str.size() - 2);
    
    v.assign(len, 0); 
    s.assign(len, 0);
    recurr(str);

    for(int i = 0; i < len; i++){
        cout << s[i];
        if(i != len - 1) cout << " ";
    }
    cout << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    string str;
    while(cin >> str >> len) solve(str);
}