#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string line;
    while (getline(cin, line)) {
        if (line.empty()) break;

        int len = line.size();
        string doubled = line + line;
        unordered_set<string> seen;
        bool first = true;

        for (int i = 0; i < len; i++) {
            string rotated = doubled.substr(i, len);
            if (seen.insert(rotated).second) {
                if (!first) cout << ' ';
                cout << rotated;
                first = false;
            }
        }
        cout << '\n';
    }
    return 0;
}
