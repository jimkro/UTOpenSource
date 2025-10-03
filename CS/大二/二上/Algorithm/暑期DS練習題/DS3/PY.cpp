#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
    string line;
    while(getline(cin,line)){
        stack<char> st;
        for(auto &c : line){
            if(!st.empty() && c == st.top()){
                st.pop();
            }else{
                st.push(c);
            }
        }
        if(st.empty()) cout << "SUCCESS\n";
        else cout << "FAIL\n";
    }
    return 0;
}
