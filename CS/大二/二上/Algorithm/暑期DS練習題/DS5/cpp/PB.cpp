#include <bits/stdc++.h>
#define llg long long
using namespace std;

int main(){
    ios::sync_with_stdio(false); cin.tie(nullptr);
    
    vector<int> crewmates;
    int x; // 暫時讀取用的

    // crewmates
    string line;
    if(!getline(cin, line)) return 0;
    stringstream ss(line);
    while(ss >> x) crewmates.push_back(x);

    int n = crewmates.size();

    // 計算最大子陣列和(By Kadane's Algorithm)
    llg max_sum = LLONG_MIN, cur = 0;
    for(int i = 0; i < n; ++i){
        cur = max((llg)crewmates[i], cur + crewmates[i]);
        max_sum = max(max_sum, cur);
    }

    // prefix sum
    vector<llg> prefix(n + 1, 0);
    for(int i = 1; i <= n; i++) prefix[i] = prefix[i-1] + crewmates[i-1];

    // 查詢各輸入
    while(cin >> x){
        int Q = x;

        // 剪枝
        if(Q > max_sum){
            cout << "0\n";
            continue;
        }

        // Monotonic Queue 維護可能起點
        deque<int> dq;
        int ans = n;

        for(int i = 0; i <= n; ++i){
            // 如果找到一個可能的區間就更新最小值, 並且因為我只會繼續往右走, 所以之後以 dq.front() 當起點的區間長度不會再更小了
            while(!dq.empty() && prefix[i] - prefix[dq.front()] >= Q){
                ans = min(ans, i - dq.front());
                dq.pop_front();
            }
            // prefix[i] 比較小 index又比較靠右, 所以原本在dq.back()的起點就不需要了
            while(!dq.empty() && prefix[i] <= prefix[dq.back()]){ 
                dq.pop_back();
            }
            // 加入候選起點
            dq.push_back(i);
        }

        cout << ans << "\n";
    }
    return 0;
}
