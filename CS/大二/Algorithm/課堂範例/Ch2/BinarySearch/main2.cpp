// solve by recursion
#include <bits/stdc++.h>
using namespace std;

int binarySearch(const vector<int>& arr, int l, int r, int query){
    if(l > r) return -1;
    int mid = l + (r - l) / 2;
    if(arr[mid] == query) return mid;
    else if(arr[mid] < query) return binarySearch(arr, mid + 1, r, query);
    else return binarySearch(arr, l, mid - 1, query);
}

int main(){
    int n; cin >> n;
    vector<int> arr(n);
    for(int i=0; i<n; i++) cin >> arr[i];

    int query;
    while(cin >> query){
        // binary search
        int ans = binarySearch(arr, 0, n - 1, query);

        // output
        if(ans == -1) cout << "Does Not Exist\n";
        else cout << ans << "\n";
    }
}