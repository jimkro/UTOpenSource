#include<bits/stdc++.h>
using namespace std;

int change(const int curr,const int low, const vector<int>& b){
    int l = 0, r = b.size() - 1;
    int resIdx = -1;
    while(l <= r){
        int m = l + (r - l) / 2;
        
        if(b[m] - curr >= low){
            resIdx = m;
            r = m - 1;
        }else{
            l = m + 1;
        }
    }
    if(resIdx == -1) return INT_MAX;
    return b[resIdx] - curr;
}

void solve(){
    int n, m; cin >> n >> m;
    vector<int> a(n + 1); for(int i=1;i<=n;i++) cin >> a[i];
    vector<int> b(m); for(int i=0;i<m;i++) cin >> b[i];
    sort(b.begin(), b.end());
    a[0] = INT_MIN;


    for(int i = 1; i <= n ;i++){
        int c = change(a[i], a[i - 1], b);
        // cout << "c : " << c << "\n";
        if(a[i - 1] > a[i]){
            if(c == INT_MAX || a[i-1] > c){
                cout << "NO\n";
                return;
            }else{
                a[i] = c;
            }
        }else{
            if(c != INT_MAX && c < a[i]){
                a[i] = c;
            }
        }
        // for(int x : a) cout << x << " ";
        // cout << "\n";
    }
    cout << "YES\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int t; cin >> t;
    while(t--) solve();
}