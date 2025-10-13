#include <bits/stdc++.h>
using namespace std;

struct Node {
    int val;
    Node* left;
    Node* right;
    Node(int v) : val(v), left(nullptr), right(nullptr) {}
};

void dfs(int idx, vector<Node*>& tree, vector<int>& path, int sum) {
    Node* root = tree[idx];
    if (!root) return;

    path.push_back(idx);
    sum += root->val;

    if (!root->left && !root->right) { // 葉節點
        cout << "The route ";
        for (int i = 0; i < (int)path.size(); i++) {
            cout << path[i];
            if (i < (int)path.size() - 1) cout << "->";
        }
        cout << " took " << sum << ".\n";
    } else {
        if (root->left) dfs(2 * idx + 1, tree, path, sum);
        if (root->right) dfs(2 * idx + 2, tree, path, sum);
    }

    path.pop_back();
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string line;
    while (getline(cin, line)) {
        if (line.empty()) continue;

        stringstream ss(line);
        vector<Node*> tree;
        string token;

        // input
        while (ss >> token) {
            if (token == "None") {
                tree.push_back(nullptr);
            } else {
                tree.push_back(new Node(stoi(token)));
            }
        }

        if (tree.empty() || !tree[0]) continue;

        // link
        for (int i = 0; i < (int)tree.size(); i++) {
            if (!tree[i]) continue;
            int leftIdx = 2 * i + 1;
            int rightIdx = 2 * i + 2;
            if (leftIdx < (int)tree.size()) tree[i]->left = tree[leftIdx];
            if (rightIdx < (int)tree.size()) tree[i]->right = tree[rightIdx];
        }

        vector<int> path;
        dfs(0, tree, path, 0);

    }
    return 0;
}
