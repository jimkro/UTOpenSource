#include <bits/stdc++.h>
using namespace std;

bool can(const vector<int>& wood, const vector<int>& width, int key){
    int w = 0;
    int cnt = 0;
    for(int i=0;i<wood.size();i++){
        while(w < width.size() && width[w] == 0) w++;
        if(w >= width.size()) return true;
        if(wood[i] >= key){
            cnt++;
        }else{
            cnt = 0;
        }

        if(cnt >= width[w]){
            w++;
            cnt = 0;
        }
    }
    return false;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    
    int n,p;
    while(cin >> n >> p){
        
        int l = 0, r = 0;
        vector<int> wood(n), width(p);
        for(int i=0;i<n;i++){
            cin >> wood[i];
            r = max(r,wood[i]);
        }
        for(int i=0;i<p;i++) cin >> width[i];

        
        int ans = -1;
        while(l <= r){
            int m = l + (r - l) / 2;

            if(can(wood,width,m)){
                ans = m;
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        cout << ans << "\n";
    }
}