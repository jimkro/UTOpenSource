#include <bits/stdc++.h>
using namespace std;

int main() {
    string a, b;

    while (cin >> a >> b) {
        int n = a.size();
        vector<int> diff;

        for (int i = 0; i < n; ++i) {
            if (a[i] != b[i]) {
                diff.push_back(i);
            }
        }

        bool isRelated = false;

        if (diff.size() == 0) {
            isRelated = true;
        } else if (diff.size() == 2) {
            int i = diff[0], j = diff[1];
            if (a[i] == b[j] && a[j] == b[i]) {
                isRelated = true;
            }
        }

        cout << (isRelated ? "True" : "False") << '\n';
    }

    return 0;
}
