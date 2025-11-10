#include<bits/stdc++.h>
using namespace std;
int n, W, maxProfit;
vector<int> weights, profits;

// === Ch4 DP ===
// 基礎款(教科書解法)
/*
    Time Complexity : O(n * W)
    Space Complexity : O(n * W)
*/
void dp_2D(){
    vector<vector<int>> dp(n+1, vector<int>(W+1));

    for(int i=1;i<=n;i++){
        for(int w=0;w<=W;w++){
            dp[i][w] = dp[i-1][w];
            if(w >= weights[i-1]) dp[i][w] = max(dp[i-1][w], profits[i-1] + dp[i-1][w - weights[i-1]]);
        }
    }
    cout << "2D DP : " << dp[n][W] << "\n";
}

// 技巧款
/*
    Time Complexity : O(n * W)
    Space Complexity : O(max(n, W))
*/
void dp_1D(){
    vector<int> dp(W + 1);

    for(int i = 0; i < n; i++){
        for(int w = W; w >= weights[i]; w--){
            dp[w] = max(dp[w], profits[i] + dp[w - weights[i]]);
        }        
    }

    cout << "1D DP : " << dp[W] << "\n";
}

// === Ch5 Brute Force ===
// brute_force 的 輔助函式
void dfs(int i, int total_w, int total_p){
    if(i == n){
        maxProfit = max(maxProfit, total_p);
        return;
    }
    dfs(i + 1, total_w, total_p);
    if(total_w + weights[i] <= W) dfs(i + 1, total_w + weights[i], total_p + profits[i]);
}

/*
    Time Complexity : O(2^n)
    Space Complexity : O(n)
*/
void brute_force(){
    maxProfit = 0;
    dfs(0, 0, 0);
    cout << "Brute Force : " << maxProfit << "\n";
}

// === Ch6 Branch and Bound === 
struct item {
    int profit, weight;
    double average; // 單位價值 (p/w)
    
    item() : profit(0), weight(0), average(0.0) {}
    
    item(int profit, int weight) : profit(profit), weight(weight) {
        if (weight > 0) average = (double)profit / weight;
        else average = 0.0; // 避免除以零
    }
};

struct node {
    int idx;    // 當前在考慮第幾個物品 (tree level)
    int profit; // 目前累積的獲利
    int weight; // 目前累積的重量
    double bound;  // 樂觀估計的獲利上限 (Bound)

    node() : idx(0), profit(0), weight(0), bound(0.0) {}
    
    node(int idx, int profit, int weight, double bound)
        : idx(idx), profit(profit), weight(weight), bound(bound) {}
};

double calBound(int idx, int profit, int weight, const vector<item>& items) {
    
    double res_bound = (double)profit;
    int current_weight = weight;
    
    // 從下一個物品 (idx + 1) 開始，嘗試用最樂觀的方式放入
    int k = idx + 1;
    
    // 只要放得下，就整包放進去
    while (k <= n && current_weight + items[k].weight <= W) {
        current_weight += items[k].weight;
        res_bound += items[k].profit;
        k++;
    }

    // 如果還有物品 (k <= n) 且背包還沒滿
    // 就把物品 k「切碎」放進剩餘空間 (Fractional Knapsack)
    if (k <= n) {
        int remaining_weight = W - current_weight;
        res_bound += (double)remaining_weight * items[k].average;
    }

    return res_bound;
}

void branch_and_bound() {
    maxProfit = 0;
    
    vector<item> items(n + 1);
    for (int i = 1; i <= n; i++) {
        items[i] = item(profits[i-1], weights[i-1]);
    }

    // sort：按「單位價值」降序
    sort(items.begin() + 1, items.end(), [](const item& item1, const item& item2) {
        return item1.average > item2.average;
    });

    // 設定 PQ
    auto pqCmp = [](const node& node1, const node& node2) {
        return node1.bound < node2.bound; // 建立 Max Heap (bound 越高越優先)
    };
    priority_queue<node, vector<node>, decltype(pqCmp)> pq(pqCmp);

    double root_bound = calBound(0, 0, 0, items);
    pq.push(node(0, 0, 0, root_bound));

    // B&B 迴圈
    while (!pq.empty()) {
        node curr = pq.top(); pq.pop();

        // 剪枝 :
        // 如果這個節點的「樂觀估計」比我們「已找到的 maxProfit」還差
        // 那就沒有必要再探索下去了
        if (curr.bound <= maxProfit) continue;
        
        // 更新目前找到的最佳的合法解
        maxProfit = max(maxProfit, curr.profit);

        // level == n，已經到底了就不用再分支
        if (curr.idx == n) continue;
        
        int next_idx = curr.idx + 1;

        // 選
        if (curr.weight + items[next_idx].weight <= W) {
            int next_profit = curr.profit + items[next_idx].profit;
            int next_weight = curr.weight + items[next_idx].weight;
            
            // 計算選了之後的 bound
            double next_bound = calBound(next_idx, next_profit, next_weight, items);

            // bound 還有希望時，才加入
            if (next_bound > maxProfit) pq.push(node(next_idx, next_profit, next_weight, next_bound));
        }

        // 不選
        double next_bound_dont_take = calBound(next_idx, curr.profit, curr.weight, items);

        // bound 還有希望時，才加入
        if (next_bound_dont_take > maxProfit) pq.push(node(next_idx, curr.profit, curr.weight, next_bound_dont_take));
    }

    // 輸出
    cout << "B&B : " << maxProfit << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    while(cin >> n >> W){
        weights.assign(n, 0);
        profits.assign(n, 0);
        for(int i=0;i<n;i++) cin >> profits[i];
        for(int i=0;i<n;i++) cin >> weights[i];
        // dp_2D();
        // dp_1D();
        // brute_force();
        // branch_and_bound();
    }
    
}