#include<bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    string v; cin >> v;
    sort(v.begin(), v.end());
    string res;
    int cnt = 0;
    for(char x : v){
        if(x == '0'){
            cnt++;
        }else{
            res.push_back(x);
        }
    }
    string z;
    if(cnt > 0){
        while(cnt--){
            z.push_back('0');
        }
    }
    cout << res[0];
    cout << z;
    for(int i=1;i<res.size();i++){
        cout << res[i];
    }
    
}