#include <bits/stdc++.h>
// <memory> 標頭檔不再需要了
using namespace std;
int n;
vector<string> res;

struct Node {
    char ch;
    int val;
    Node* left;
    Node* right;

    Node() : ch('_'), val(0), left(nullptr), right(nullptr) {}
    Node(char ch, int val) : ch(ch), val(val), left(nullptr), right(nullptr) {}
};

struct cmp {
    bool operator()(const Node* a, const Node* b) const {
        if (a->val != b->val) return a->val > b->val; // val 小的優先
        return a->ch > b->ch; // val 相同時，ch 小的優先
    }
};

void show(Node* root, string code) {
    if (root == nullptr) return;

    // Base Case : 葉節點
    if (root->ch != '_') {
        res.push_back(string(1, root->ch) + " = " + code + "\n");
        return;
    }
    
    show(root->left, code + "0");
    show(root->right, code + "1");
}

void solve() {
    res.clear();
    priority_queue<Node*, vector<Node*>, cmp> pq;

    while (n--) {
        char ch;
        int val;
        cin >> ch >> val;
        pq.push(new Node(ch, val));
    }

    while (pq.size() > 1) {
        Node* root = new Node(); 

        root->left = pq.top(); pq.pop();
        root->right = pq.top(); pq.pop();

        root->ch = '_';
        root->val = root->left->val + root->right->val;

        pq.push(root);
    }

    Node* root = pq.top();
    show(root, "");
    sort(res.begin(), res.end());

    for (auto s : res) cout << s;
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    while (cin >> n) {
        if (n == 0) break;
        solve();
    }
}