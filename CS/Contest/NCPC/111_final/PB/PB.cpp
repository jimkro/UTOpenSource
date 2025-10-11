#include<bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int T; cin >> T;
    string num;

    while(T--){
        cin >> num;
        int i = 0;
        int cnt = 0;
        int len = num.size();
        string ans = "Yes";
        while(cnt < len){
            if(num[i] == 'x'){
                ans = "No";
                break;
            }

            int next = (i + num[i] - '0') % len;
            num[i] = 'x';
            i = next;
            cnt++;
        }

        cout << ans << "\n";
    }
}