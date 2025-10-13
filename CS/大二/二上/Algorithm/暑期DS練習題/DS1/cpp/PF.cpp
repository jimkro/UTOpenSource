#include <bits/stdc++.h>

using namespace std;

priority_queue<int> low;
priority_queue<int, vector<int>, greater<int>> high;

void addNum(int num) {

    if (low.empty() || num <= low.top()) {
        low.push(num);
    } else {
        high.push(num);
    }

    if (low.size() > high.size() + 1) {
        high.push(low.top());
        low.pop();
    } else if (high.size() > low.size()) {
        low.push(high.top());
        high.pop();
    }
}

int getMedian() {
    if (low.size() == high.size()) {
        return (low.top() + high.top()) / 2;
    } else {
        return low.top();
    }
}
int main() {
    int n;
    cin >> n;
    while(n--) {
        int k;
        cin >> k;
        low = priority_queue<int>();
        high = priority_queue<int, vector<int>, greater<int>>();
        long long sum = 0;
        while(k--) {
            int num;
            cin >> num;
            addNum(num);
            sum += getMedian();
        }
        cout << sum << endl;
    }
    
    return 0;
}
