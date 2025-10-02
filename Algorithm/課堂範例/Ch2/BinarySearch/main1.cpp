// solve by while
#include <bits/stdc++.h>
using namespace std;

int main(){
    int n; cin >> n;
    vector<int> arr(n);
    for(int i=0; i<n; i++) cin >> arr[i];

    int query;
    while(cin >> query){
        // binary search
        int l = 0, r = n - 1;
        int ans = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] == query){
                ans = mid;
                break;
            }
            else if(arr[mid] < query) l = mid + 1;
            else r = mid - 1;
        }

        // output
        if(ans == -1) cout << "Does Not Exist\n";
        else cout << ans << "\n";
    }
}