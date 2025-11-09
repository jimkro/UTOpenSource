#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n, q; cin >> n >> q;
    string types; cin >> types;
    bool onlyA = true; 
    for(char c : types){
        if(c == 'B'){
            onlyA = false;
            break;
        }
    }
    while(q--){
        int curr; cin >> curr;
        if(onlyA){
            cout << curr << "\n";
            continue;
        }
        int i = 0;
        long long cnt = 0;
        while(curr != 0){
            if(types[i] == 'A'){
                curr--;
            }else{
                curr /= 2;
            }

            i = (i + 1) % n;
            cnt++;
        }
        cout << cnt << "\n";
    }
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}