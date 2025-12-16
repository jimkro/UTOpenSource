#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    string s; cin >> s;
    sort(s.begin(), s.end());
    ostringstream oss;
    long long cnt = 0;
    do{
        cnt++;
        oss << s << "\n";
    }while(next_permutation(s.begin(), s.end()));
    string res = oss.str();

    cout << cnt << "\n" << res;
}