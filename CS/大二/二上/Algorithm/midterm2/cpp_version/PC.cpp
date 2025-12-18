#include <bits/stdc++.h>
using namespace std;

bool isPrime(int n){
    if(n < 2) return false;

    for(int i = 2; i * i <= n; i++){
        if(n % i == 0) return false;
    }
    return true;
}

int main() {
    ios::sync_with_stdio(0);cin.tie(0);
    int T; cin >> T;
    for(int t = 1; t <= T; t++){
        cout << "Case " << t << ": ";
        unordered_map<char, int> mp;
        string s; cin >> s;
        for(char c : s) mp[c]++;

        string res = "";
        
        for(auto& p : mp){
            if(isPrime(p.second)){
                res += (char)p.first;
            }
        }

        sort(res.begin(), res.end());
        if(res.empty()) res = "empty";
        cout << res << "\n";
    }
    return 0;
}