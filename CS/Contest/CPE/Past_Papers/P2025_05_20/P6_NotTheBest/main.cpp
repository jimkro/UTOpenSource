#include<bits/stdc++.h>
using namespace std;
using ll = long long;
int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int V, E;

    while(cin >> V >> E && (V != 0 || E != 0)){
        int start, end, k; cin >> start >> end >> k;
        vector<vector<pair<ll,int>>> adj(V + 1,vector<pair<ll,int>>()); // v1 -> {w, v2};

        for(int i = 0; i < E; i++){
            int v1, v2, w; cin >> v1 >> v2 >> w;
            adj[v1].emplace_back(w,v2);
        }

        priority_queue<pair<ll,int>, vector<pair<ll,int>>, greater<pair<ll,int>>> pq; // {w, curr}
        pq.push({0,start});
        
        vector<int> cnt(V + 1, 0);
        ll ans = -1;
        while(!pq.empty()){
            auto [w, curr] = pq.top(); pq.pop();

            cnt[curr]++;
            if(curr == end && cnt[curr] == k){
                ans = w;
                break;
            }

            if(cnt[curr] > k) continue; // 代表他根本到不了，因為如果他經過了 k + 1 次到得了早就累計 k 次了，例如 1 <-> 2 (目標是到2)，那兩個點都經過 k 次時就會結束了。 

            for(auto x : adj[curr]){
                if(cnt[x.second] > k) continue;
                pq.push({w + x.first,  x.second});
            }
        }
        
        cout << ans << "\n";
    }
}