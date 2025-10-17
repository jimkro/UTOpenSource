#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll treeSum(int root, const vector<int>& tree) {
    if (root >= tree.size() || tree[root] == -1) return 0;
    return tree[root] + treeSum(2 * root + 1, tree) + treeSum(2 * root + 2, tree);
}

ll treeMulti(int root,ll total_sum ,const vector<int>& tree) {
    ll curr_sum = treeSum(root, tree);
    return curr_sum * (total_sum - curr_sum);
}

int main() {
    ios::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
    
    string line;
    while(getline(cin,line)){
        istringstream iss(line);
        vector<int> tree;
        string token;
        ll total_sum = 0;
        
        while(iss >> token){
            if(token != "None" ) total_sum += stoi(token);
            tree.push_back(token == "None" ? -1 : stoi(token));
        }

        int n = tree.size();
        
        
        ll ans = 0;
        for(int curr=0;curr<n;curr++){

            int l = 2 * curr + 1;
            int r = 2 * curr + 2;

            // 斷開左子樹
            if(l >= n || tree[l] == -1) continue;
            ans = max(ans, treeMulti(l, total_sum, tree));

            // 斷開右子樹
            if(r >= n || tree[r] == -1) continue;
            ans = max(ans, treeMulti(r, total_sum, tree));
            
        }
        
        cout << ans << "\n";

    }
    return 0;
}
