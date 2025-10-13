#include <bits/stdc++.h>

using namespace std;

void buildPostOrder(const string &pre, int preL, int preR,
                    const string &in, int inL, int inR,
                    unordered_map<char, int> &inPos) {
    if (preL > preR || inL > inR) return;

    char root = pre[preL];
    int rootIdx = inPos[root];
    int leftSize = rootIdx - inL;

    buildPostOrder(pre, preL + 1, preL + leftSize, in, inL, rootIdx - 1, inPos);
    buildPostOrder(pre, preL + leftSize + 1, preR, in, rootIdx + 1, inR, inPos);

    cout << root;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while (t--) {
        int n;
        string pre, in;
        cin >> n >> pre >> in;

        unordered_map<char, int> inPos;
        for (int i = 0; i < n; i++) {
            inPos[in[i]] = i;
        }

        buildPostOrder(pre, 0, n - 1, in, 0, n - 1, inPos);
        cout << "\n";
    }
}
