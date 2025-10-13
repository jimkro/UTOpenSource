#include <bits/stdc++.h>
using namespace std;

// 判斷是否為樹
bool isTree(const map<int, vector<int>>& graph, const map<int,int>& indegree, int& root) {
    set<int> nodes;
    for (auto& p : graph) {
        nodes.insert(p.first);
        for (int v : p.second) nodes.insert(v);
    }

    if (nodes.empty()) { // 空樹特例 (雖然就題目的條件，理論上輸入不存在空樹)
        root = 0;
        return true;
    }

    // 找 root 並檢查 indegree 條件
    root = -1;
    for (int x : nodes) {
        int d = indegree.count(x) ? indegree.at(x) : 0;
        if (d == 0) {
            if (root == -1) root = x;  // 第一個 root
            else return false;          // 出現第二個 root → 不唯一
        } else if (d > 1) return false;  // 非根節點入度 > 1 → 不是樹
    }
    if (root == -1) return false; // 沒找到 root

    // BFS 遍歷檢查連通性
    set<int> visited;
    queue<int> q;
    q.push(root);
    visited.insert(root);

    while (!q.empty()) {
        int u = q.front(); q.pop();
        if (!graph.count(u)) continue;
        for (int v : graph.at(u)) {
            if (!visited.count(v)) {
                visited.insert(v);
                q.push(v);
            }
        }
    }

    return visited.size() == nodes.size(); // 所有節點都能從 root 到達
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int caseNo = 1;
    while (true) {
        map<int, vector<int>> graph;
        map<int, int> indegree;

        int u, v;
        while (cin >> u >> v) {
            if (u < 0 && v < 0) return 0; // 整個輸入結束
            if (u == 0 && v == 0) break;  // 單筆測資結束

            graph[u].push_back(v);
            indegree[v]++;
        }

        int root = 0;
        if (isTree(graph, indegree, root)) {
            cout << "Case " << caseNo++ << " is a tree. Root is " << root << ".\n";
        } else {
            cout << "Case " << caseNo++ << " is not a tree.\n";
        }
    }
}
