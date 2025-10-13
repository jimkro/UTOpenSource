#include <bits/stdc++.h>
using namespace std;

struct Info {
    vector<string> adj;
    int w;
};

map<string, Info> mp;
map<string, vector<int>> dp; // dp[u][0 or 1]

int dfs(const string &u, bool take) {
    if (dp[u][take] != -1) return dp[u][take];

    int res = 0;

    if(take){
        res = mp[u].w;
        for (auto &v : mp[u].adj) res += dfs(v, 0);
            
    }else{
        for (auto &v : mp[u].adj) res += max(dfs(v, 0), dfs(v, 1));
    }

    return dp[u][take] = res;
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);

    int N;
    while (cin >> N) {
        if (N == 0) break;

        mp.clear();
        dp.clear();
        unordered_set<string> st;

        for (int i = 0; i < N; ++i) {
            string name; int w;
            cin >> name >> w;
            mp[name].w = w;
            st.insert(name);
            dp[name] = vector<int>(2, -1);
        }

        for (int i = 0; i < N - 1; ++i) {
            string boss, emp;
            cin >> boss >> emp;
            mp[boss].adj.push_back(emp);
            st.erase(emp);
        }

        // 爹地
        string root = *st.begin();
        cout << max(dfs(root, 0), dfs(root, 1)) << "\n";
    }
}