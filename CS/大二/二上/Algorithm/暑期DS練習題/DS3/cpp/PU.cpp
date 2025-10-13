#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
    int n;
    while(cin >> n && n != 0){
        vector<int> v(n);
        for(int i=0;i<n;i++) cin >> v[i];
        sort(v.begin(),v.end());
        int pairs = n / 2;
        cout << pairs << "\n";
        
        for(int i=0;i<pairs;i++) cout << (v[i] + v[n-1-i]) << " ";
        cout << "\n";
    }
    return 0;
}
