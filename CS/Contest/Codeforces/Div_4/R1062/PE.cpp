#include<bits/stdc++.h>
using namespace std;
int n, k, x;
vector<int> pos;
vector<int> res;

bool check(int gap){

    if(gap == 0){
        iota(res.begin(), res.end(), 0);
        return true;
    }
    
    vector<int> tmp(k);
    int idx = 0;

    // 左右底
    if(pos[0] - gap >= 0){
        int val = 0, end = pos[0] - gap;
        while(idx < k && val <= end){
            tmp[idx++] = val++;
        }

        if(idx >= k){
            copy(tmp.begin(), tmp.end(), res.begin());
            return true;
        }
    }

    if(pos[n-1] + gap <= x){
        int val = pos[n-1] + gap, end = x;

        while(idx < k && val <= end){
            tmp[idx++] = val++;
        }

        if(idx >= k){
            copy(tmp.begin(), tmp.end(), res.begin());
            return true;
        }
    }

    for(int i = 0; i < n - 1; i++){
        int l = pos[i] + gap, r = pos[i+1] - gap;
        if(r - l >= 0){
            int val = l, end = r;

            while(idx < k && val <= end){
                tmp[idx++] = val++;
            }

            if(idx >= k){
                copy(tmp.begin(), tmp.end(), res.begin());
                return true;
            }
        }
    }

    return false;

}

void solve(){
    // 輸入
    cin >> n >> k >> x;
    pos.assign(n,0); for(int i=0;i<n;i++) cin >> pos[i];
    pos.erase(unique(pos.begin(), pos.end()), pos.end());
    sort(pos.begin(), pos.end());
    res.assign(k,0);

    n = pos.size();

    int l = 0, r = x, gap = INT_MIN;

    while(l <= r){
        int m = l + (r - l) / 2;
        
        if(check(m)){
            gap = m;
            l = m + 1;
        }else{
            r = m - 1;
        }
    }

    // cout << "gap : " << gap << "\n";
    for(int x : res) cout << x << " ";
    cout << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}

/*
k = 3
1 10 15
1 ~ 10
1 + k ~ 10 - k
4 ~ 7

4

*/