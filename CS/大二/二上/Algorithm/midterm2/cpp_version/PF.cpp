#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    while(cin >> n) {
        vector<pair<int, int>> jobs(n);
        
        for(int i = 0; i < n; i++) cin >> jobs[i].first >> jobs[i].second;
        sort(jobs.begin(), jobs.end());

        priority_queue<int, vector<int>, greater<int>> pq;

        int max_needed = 0;

        for(const auto& job : jobs) {
            int start = job.first;
            int end = job.second;

            while(!pq.empty() && pq.top() <= start) pq.pop();

            pq.push(end);
            max_needed = max(max_needed,(int)pq.size());
        }

        cout << max_needed << "\n";
    }
}

int main() {
    ios::sync_with_stdio(0);cin.tie(0);
    solve();
    return 0;
}