#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    while(cin >> n){
        vector<int> graph(n,-1);
        unordered_set<int> vist1, vist2;
        int ans = -1;
        for(int i = 0;i < n-1;i++){
            int u,v; cin >> u >> v;
            graph[v] = u;
        }

        int t1,t2; cin >> t1 >> t2;
        vist1.insert(t1);
        vist2.insert(t2);

        while(true){
            if(vist1.count(t2)){
                ans = t2;
                break;
            }
            if(vist2.count(t1)){
                ans = t1;
                break;
            }

            if(graph[t1] != -1){
                t1 = graph[t1];
                vist1.insert(t1);
                // cout << "t1 = " << t1 << '\n';
            }

            if(graph[t2] != -1){
                t2 = graph[t2];
                vist2.insert(t2);
                // cout << "t2 = " << t2 << '\n';
            }

        }
        cout << ans << '\n';
    }
    return 0;
}
