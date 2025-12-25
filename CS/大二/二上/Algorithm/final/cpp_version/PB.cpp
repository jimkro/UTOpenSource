#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--){
        string s; cin >> s;
        int tmp = (3 - s.size() % 3) % 3;
        while(tmp--) s = "0" + s;
        bool f = true;
        long long res = 0;
        for(int i = s.size(); i > 0; i -= 3){
            int val = stoi(s.substr(i - 3, 3));
            if(f){
                res += val;
            }else{
                res -= val;
            }
            f = !f;
        }
        res = abs(res);
        cout << res << " ";
        if(res % 13 == 0){
            cout << "YES\n";
        }else{
            cout << "NO\n";
        }
    }
}