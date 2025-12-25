#include <bits/stdc++.h>
using namespace std;

struct Pt{
    int id, d, f;
    Pt(){}
    Pt(int id, int d, int f): id(id), d(d), f(f){}

    bool operator<(const Pt& o) const {
        if(f != o.f) return f < o.f;
        if(d != o.d) return d > o.d;
        return id > o.id;
    }
};

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int V, E, start;

    while(cin >> V >> E >> start){
        if(V == 0 && E == 0 && start == 0)break;
        vector<vector<Pt>> g(V+1);
        for(int i = 0; i < E; i++){
            int u, v, d, f;
            cin >> u >> v >> d >> f;
            g[u].push_back({v, d, f});
            g[v].push_back({u, d, f});
        }

        priority_queue<Pt> pq;
        pq.push({start, 0, 0});
        int cnt = 0;
        vector<bool> visited(V + 1);
        while(!pq.empty() && cnt < V){
            auto cur = pq.top(); pq.pop();
            int id = cur.id, d = cur.d, f = cur.f;
            if(visited[id]) continue;
            visited[id] = true;
            cout << id << " ";
            cnt++;
            for(auto nt : g[id]){
                int ntId = nt.id, ntD = nt.d, ntF = nt.f;
                if(!visited[ntId]){
                    pq.push({ntId, ntD, ntF});
                }
            }
        }
        cout << "\n";
    }
}