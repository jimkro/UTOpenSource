/*
    skill : DSU
*/
#include <bits/stdc++.h>
using namespace std;

// DSU 結構
struct DSU {
    vector<int> parent;
    DSU(int V) : parent(V + 1) {
        // 將 parent 初始化為 [0, 1, 2, ..., V]，先自己當自己的爸爸
        iota(parent.begin(), parent.end(), 0);
    }

    // 尋找代表節點 (帶路徑壓縮)
    int find(int i) {
        return parent[i] == i ? i : parent[i] = find(parent[i]);
    }

    // 合併兩個集合 (這裡我們不需要按大小/秩合併，因為結構很簡單)
    // 但我們需要知道是否真的發生了合併
    bool unite(int i, int j) {
        int root_i = find(i);
        int root_j = find(j);
        if (root_i != root_j) {
            parent[root_i] = root_j;
            return true; // 成功合併
        }
        return false; // 本來就在同一個集合
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int V; cin >> V;
    
    // 為了儲存父節點關係
    vector<int> parents(V + 1);
    for (int i = 2; i <= V; ++i) {
        cin >> parents[i];
    }

    vector<int> targetColor(V + 1);
    for (int i = 1; i <= V; ++i) {
        cin >> targetColor[i];
    }

    // 初始化 DSU
    DSU dsu(V);
    
    // 初始答案為 V (假設每個節點都需要一次獨立操作)
    int operations = V;

    // 從節點 2 開始遍歷，檢查每個節點與其父節點的關係
    for (int i = 2; i <= V; ++i) {
        int p = parents[i];
        // 如果子節點和父節點的目標顏色相同
        if (targetColor[i] == targetColor[p]) {
            // 我們可以將它們合併到同一個染色任務中
            // 如果 unite 成功 (它們之前不在同一個集合)，說明我們節省了一次操作
            if (dsu.unite(i, p)) {
                operations--;
            }
        }
    }

    // 輸出
    cout << operations << endl;

    return 0;
}