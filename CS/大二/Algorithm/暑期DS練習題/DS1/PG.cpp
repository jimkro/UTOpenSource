#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;
    while(n--) {
        string str;
        cin >> str;
        int cnt = 1;
        int sum = 0;
        for(char &c : str) {
            if(c == 'O'){
                sum += cnt;
                cnt++;
            } else {
                cnt = 1;
            }
        }
        cout << sum << endl;
    }
    
    return 0;
}
