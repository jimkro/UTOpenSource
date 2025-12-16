#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    bool hasN = false;
    while(hasN || cin >> n) {
        hasN = false;
        vector<int> ans(n);
        for(int i = 0; i < n; i++) cin >> ans[i];
        cin.ignore(); // 清掉換行

        // pri[i] = 正確序列中事件 i 的順位
        vector<int> pri(n+1);
        for(int i=0;i<n;i++) pri[i+1] = ans[i];

        string line;
        while(getline(cin, line)) {
            if(line.empty()) continue;
            istringstream ss(line);
            vector<int> test(n);
            for(int i=0;i<n;i++) ss >> test[i];

            if(ss.fail() || test.size() == 1) { 
                // 下一個 n
                n = test[0];
                hasN = true;
                break;
            }

            // v[t] = 學生序列中事件 t 的位置
            vector<int> v(n+1);
            for(int i=0;i<n;i++) v[test[i]] = i+1;

            // 計算 LIS
            vector<int> lis;
            for(int i=1;i<=n;i++){
                int t = v[i];
                if(lis.empty() || pri[lis.back()] < pri[t]) lis.push_back(t);
                else{
                    auto it = lower_bound(lis.begin(), lis.end(), t, [&](int a,int b){ return pri[a] < pri[b]; });
                    *it = t;
                }
            }

            cout << lis.size() << "\n";
        }
    }
}
