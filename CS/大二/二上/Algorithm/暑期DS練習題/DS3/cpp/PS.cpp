#include <bits/stdc++.h>
using namespace std;

vector<string> split(const string& line, int factor) {
    vector<string> ans;
    int size = line.size();
    for (int i = 0; i + factor <= size; i += factor) {
        ans.push_back(line.substr(i, factor));
    }
    return ans;
}

bool solve(const string& line, int factor) {
    vector<string> parts = split(line, factor);
    sort(parts.begin(), parts.end());
    string newLine = accumulate(parts.begin(), parts.end(), string{});
    if (line != newLine) {
        cout << newLine << '\n';
        return true;
    }
    return false;
}

int main() {
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    string line;
    while (cin >> line) {
        int size = line.size();
        vector<int> otherFactors;
        bool changed = false;

        for (int i = 1; i * i <= size; ++i) {
            if (size % i == 0) {
                if (solve(line, i)) changed = true;
                if (i != size / i) otherFactors.push_back(size / i);
            }
        }

        for (int i=otherFactors.size()-1;i>=0;i--) {
            int f = otherFactors[i];
            if (solve(line, f)) changed = true;
        }

        if (!changed) cout << "orz\n";
    }

    return 0;
}
