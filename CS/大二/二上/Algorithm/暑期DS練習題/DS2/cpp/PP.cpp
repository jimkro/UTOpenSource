#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);cin.tie(nullptr);

    int n,m;
    int cnt = 1;
    while (cin >> n && n != 0 && cin >> m) {
        vector<int> v;
        int sv = 0;
        int pv = 0;
        for(int i=0; i < n; i++) {
            int min = INT_MAX;
            for(int j=0; j < n; j++) {
                int num;
                cin >> num;
                int gap = abs(num - m);
                if(gap < min) min = gap;
                v.push_back(gap);
            }
            sv += min;
        }
        nth_element(v.begin(), v.begin() + n, v.end());
        pv = accumulate(v.begin(), v.begin() + n, 0);
        
        cout << "Case " << cnt++ << ": " << pv << " VS. " << sv << '\n';
        if(sv == pv) cout << "Perfect Teammate.\n";
        else cout << "Just Teammate.\n";

    }
    return 0;
}

