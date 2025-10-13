#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
    
    int V,E,T;
    while(cin >> V >> E >> T && (V != 0 || E !=0 || T != 0)){
        vector<priority_queue<int, vector<int>, greater<int>>> graph(V+1);
        vector<bool> visited(V+1,false);
        for(int i=0;i<E;i++){
            int v1,v2;
            cin >> v1 >> v2;
            graph[v1].push(v2);
            graph[v2].push(v1);
        }

        if(T == 0){ // BFS
            queue<int> q;
            q.push(1);

            while(!q.empty()){
                int curr = q.front();
                q.pop();

                if(visited[curr]) continue;
                visited[curr] = true;

                cout << curr << " ";

                while(!graph[curr].empty()){
                    q.push(graph[curr].top());
                    graph[curr].pop();
                }
            }
            cout << "\n";
        }else{ // DFS
            stack<int> st;
            st.push(1);

            while(!st.empty()){
                int curr = st.top();
                st.pop();

                if(visited[curr]) continue;
                visited[curr] = true;

                cout << curr << " ";

                while(!graph[curr].empty()){
                    st.push(graph[curr].top());
                    graph[curr].pop();
                }
            }
            cout << "\n";
        }
        
    }
    return 0;
}
