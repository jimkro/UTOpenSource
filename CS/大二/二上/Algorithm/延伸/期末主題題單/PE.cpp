#include <bits/stdc++.h>
#define int long long
using namespace std;

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int x;
    priority_queue<int> lower;
    priority_queue<int, vector<int>, greater<int>> higher;

    while(cin >> x){
        // 選要丟哪個半邊
        if(lower.empty()) lower.push(x);
        else if(x <= lower.top()) lower.push(x);
        else higher.push(x);
        
        //平衡
        if(lower.size() > higher.size() + 1){ // lower 過多
            higher.push(lower.top());
            lower.pop();
        }else if(higher.size() > lower.size()){ // higher 過多
            lower.push(higher.top());
            higher.pop();
        }

        // output
        if(lower.size() == higher.size()) cout << (lower.top() + higher.top()) / 2;
        else cout << lower.top();
        cout << "\n";
    }
}