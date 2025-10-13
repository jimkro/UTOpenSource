#include <bits/stdc++.h>

using namespace std;

int main() {
    int l,r,target;
    while (cin >> l >> r >> target) {
        if(target < l || target > r) {
            cout << -1 << endl;
            continue;
        }
        int cnt = 0;
        while(l <= r){
            cnt++;
            int mid = (l + r) / 2;
            if(mid == target) {
                cout << cnt << endl;
                break;
            } else if(mid < target) {
                l = mid + 1;
                
            } else {
                r = mid - 1;
            }
        }
    }
    return 0;
}

