#include<bits/stdc++.h>
#define llg long long
using namespace std;

void solve() {
    llg n, k;
    cin >> n >> k;

    llg pl = 0; // 左邊 b 的位置
    llg left = 2, right = n;

    // 找 pl 位置
    while (left <= right) {
        llg mid = left + (right - left) / 2;
        llg count = mid * (mid - 1) / 2;

        if (count >= k) {
            pl = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    
    llg prev_count = (pl - 1) * (pl - 2) / 2;
    llg pr = k - prev_count; // 右邊 b 的位置

    // 建構字串
    string result(n, 'a');
    result[n - pl] = 'b';
    result[n - pr] = 'b';
    
    // 輸出
    cout << result << "\n";
}
int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int T; cin >> T;
    while(T--) solve();
}