#include <bits/stdc++.h>
#define int long long
using namespace std;

struct Item{
    string name = "";
    int cnt = 0;
    double p = 0;
    int idx = 0;
    Item(){}
    Item(string name, int cnt, double p, int idx) : 
    name(name), cnt(cnt), p(p), idx(idx){}
};

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int n, k;
    auto cmp = [&](const Item& i1, const Item& i2){
        if(i1.cnt != i2.cnt) return i1.cnt > i2.cnt;
        if(i1.p != i2.p) return i1.p < i2.p;
        return i1.idx < i2.idx;
    };
    int T = 1;
    bool first = true;
    while(cin >> n >> k){
        if(n == 0 && k == 0) break;
        if(!first){
            cout << "\n";
        }else{
            first = false;
        }
        string strTmp;
        getline(cin, strTmp);
        vector<Item> items(k);
        for(int i = 0; i < k; i++) items[i].idx = i;

        for(int i = 0; i < n; i++) getline(cin, strTmp);
        for(int i = 0; i < k; i++){
            getline(cin, items[i].name);
            cin >> items[i].p >> items[i].cnt;
            getline(cin, strTmp);
            for(int j = 0; j < items[i].cnt; j++) getline(cin, strTmp);
        }
        auto res = *min_element(items.begin(), items.end(), cmp);
        cout << "RFP #" << T++ << "\n";
        cout << res.name << "\n";

    }
    return 0;
}