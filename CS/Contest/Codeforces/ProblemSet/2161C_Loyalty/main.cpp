// AC
#include<bits/stdc++.h>
using namespace std;
#define ll long long

void solve(){
    int n, x; cin >> n >> x;
    vector<int> arr(n); for(int i=0;i<n;i++) cin >> arr[i];
    sort(arr.begin(), arr.end());
    int l = 0, r = n - 1, idx = 0;
    vector<int> resArr(n);
    ll curr = 0, res = 0;
    while(l <= r){
        if(curr + arr[l] < x){
            resArr[idx++] = arr[l];
            curr += arr[l++];
        }else{
            res += arr[r];
            curr = (curr + arr[r]) % x;
            resArr[idx++] = arr[r];
            r--;
            
        }
    }
    cout << res << "\n";
    for(int ans : resArr){
        cout << ans << " ";
    }
    cout << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int T; cin >> T;
    while(T--) solve();
}