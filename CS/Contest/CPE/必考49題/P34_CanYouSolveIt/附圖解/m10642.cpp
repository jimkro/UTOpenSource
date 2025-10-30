/*
解題想法
用講的有點抽象所以直接看圖解吧
*/

#include <bits/stdc++.h>
using namespace std;

int main() {
    long long cases, ans, len1, len2;
    pair<int, int> a1, a2;
    cin >> cases;

    for (int c = 1; c <= cases; c++) {
        ans = 0;
        cin >> a1.first >> a1.second;
        cin >> a2.first >> a2.second;

        len1 = a1.first + a1.second;
        len2 = a2.first + a2.second;

        for (int i = len1; i <= len2; i++){
            ans += i;
        }
        ans += abs(len2 - len1);
        ans -= a1.first + a2.second;

        cout << "Case " << c << ": " << ans << endl;
    }

    return 0;
}
