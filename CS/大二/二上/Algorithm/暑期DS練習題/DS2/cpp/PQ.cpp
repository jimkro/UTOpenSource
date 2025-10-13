#include <bits/stdc++.h>

using namespace std;

// sliding window + monotonic deque
bool canPlaceAll(const vector<int>& h, const vector<int>& w, int H) {
    int n = (int)h.size(), p = (int)w.size();
    int pos = 0;

    for (int width : w) {
        deque<int> dq; // Monotonic queue for minimum height in current window
        
        bool placed = false;
        for (int j = pos; j < n; j++) {
            // Maintain window size and remove out-of-range indices
            while (!dq.empty() && dq.front() <= j - width) dq.pop_front();

            // Maintain increasing order in deque
            while (!dq.empty() && h[dq.back()] >= h[j]) dq.pop_back();

            dq.push_back(j);

            // When window size >= width, check min height
            if (j - pos + 1 >= width) {
                int minH = h[dq.front()];
                if (minH >= H) {
                    pos = j + 1; // Move to next segment
                    placed = true;
                    break;
                }
                pos++;
            }
        }
        if (!placed) return false;
    }
    return true;
}

int main() {
    ios::sync_with_stdio(false); cin.tie(nullptr);cout.tie(nullptr);
    
    int n, p;

    while (cin >> n >> p) {
        // Input
        vector<int> h(n), w(p);
        for (int i = 0; i < n; i++) cin >> h[i];
        for (int i = 0; i < p; i++) cin >> w[i];
        
        // Binary search for the maximum possible height H
        int low = 0, high = *max_element(h.begin(), h.end());

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlaceAll(h, w, mid)) {
                low = mid + 1; // Try higher height
            } else {
                high = mid - 1; // Lower the height
            }
        }

        // Output
        cout << high << "\n";
    }
}
