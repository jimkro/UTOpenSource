#include<bits/stdc++.h>
using namespace std;
#define ll long long

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int n; cin >> n;
    vector<ll> v(n + 1);
    ll total = 0;
    for(int i=1;i<=n;i++){
        cin >> v[i];
        total += v[i];
    }

    if(total % n != 0){
        cout << -1;
        return 0;
    }

    ll goal = total / n;
    vector<vector<ll>> ops;
            
    

    
    while(1){
        bool swapped = false;
        // 找有沒有可以一次完成兩個人的
        for(int x = 1; x < v.size(); x++){
            if(v[x] == goal) continue;
            for(int y = x + 1; y < v.size(); y++){
                if(v[y] == goal) continue;

                if(v[x] + v[y] == 2 * goal){
                    if(v[x] > v[y]){
                        ops.push_back({x, y, (v[x] - v[y]) / 2});
                        v[x] = v[y] = goal;
                    }else{
                        ops.push_back({y, x, (v[y] - v[x]) / 2});
                        v[x] = v[y] = goal;
                    }
                    swapped = true;
                }
            }
        }
        // 剩下一次完成一個的
        bool swapped2 = false;
        for(int x = 1; x < v.size(); x++){
            if(v[x] == goal) continue;
            for(int y = x + 1; y < v.size(); y++){
                if(v[y] == goal) continue;
                if(v[x] > goal && v[y] < goal){
                    ops.push_back({x, y, (goal - v[y])});
                    v[x] -= goal - v[y];
                    v[y] = goal;
                    swapped = true;
                    swapped2 = true;
                }else if(v[x] < goal && v[y] > goal){
                    ops.push_back({y, x, (goal - v[x])});
                    v[y] -= goal - v[x];
                    v[x] = goal;
                    swapped = true;
                    swapped2 = true;
                }
                if(swapped2) break;
            }
            if(swapped2) break;
        }
        if(!swapped) break;
    }
    cout << ops.size() << "\n";
    for(auto op : ops){
        cout << op[0] << " " << op[1] << " " << op[2] << "\n";
    }
    
}