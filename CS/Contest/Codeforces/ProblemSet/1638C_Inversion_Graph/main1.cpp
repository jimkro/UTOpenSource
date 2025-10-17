#include<bits/stdc++.h>
using namespace std;

void solve() {
    int n; cin >> n;
    
    int cnt = 0;
    int mx = 0;
    
    // 邊讀邊處理，不需要把整個排列存起來
    for (int i = 0; i < n; i++) {
        int p; cin >> p;
        
        // 更新到目前為止遇到的最大值
        if (p > mx) mx = p;
        
        // 檢查是否滿足分割點條件，i+1 是目前看過的元素數量 (使用 1-based 長度)
        if (mx == i + 1) cnt++;
    }
    
    cout << cnt << "\n";
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    
    int T; cin >> T;
    while(T--) solve();
    
    return 0;
}

