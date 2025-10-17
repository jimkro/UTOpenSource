#include<bits/stdc++.h>
using namespace std;
using llg = long long;

double dis(llg x1,llg y1,llg x2,llg y2){
    return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
}

void solve(){
    llg C, D; cin >> C >> D;
    unordered_map<llg,llg> cat_cnts;
    vector<pair<llg,llg>> cats(C); for(int i=0;i<C;i++) cin >> cats[i].first >> cats[i].second;
    vector<pair<llg,llg>> dogs(D); for(int i=0;i<D;i++) cin >> dogs[i].first >> dogs[i].second;

    for(auto dog : dogs){
        llg x1 = dog.first, y1 = dog.second;
        int mnIdx = 0;
        double mn = dis(x1,y1,cats[0].first,cats[0].second);

        for(int i=1;i<C;i++){
            auto cat = cats[i];
            llg x2 = cat.first, y2 = cat.second;

            double val = dis(x1,y1,x2,y2);
            if(val < mn){
                mnIdx = i;
                mn = val;
            }
        }
        cat_cnts[mnIdx]++;
    }
    llg cnt = 0;
    for(auto [key,val] : cat_cnts){
        if(val == 1){
            cnt++;
        }
    }
    cout << cnt;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    solve();
}