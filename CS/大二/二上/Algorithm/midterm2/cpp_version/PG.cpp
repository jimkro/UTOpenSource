#include <bits/stdc++.h>
using namespace std;

void solve() {
    string s; cin >> s;
    int zeros = (3 - s.size() % 3) % 3;
    while(zeros--) s = "0" + s;

    bool positive = true;
    int tot = 0;
    for(int i = s.size(); i > 0; i -= 3){
        int val = stoi(s.substr(i - 3, 3));
        tot += positive ? val : -val;
        positive = !positive;
    }
    tot = abs(tot);
    if(tot % 13 == 0){
        cout << tot << " YES\n";
    }else{
        cout << tot << " NO\n";
    }
}

int main() {
    ios::sync_with_stdio(0);cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
    return 0;
}