#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
    int m,n;
    while (cin >> m >> n) {
        vector<int> p(m);
        vector<int> e(n);

        for(int i=0;i<m;i++){
            cin >> p[i];
        }
        for(int i=0;i<n;i++){
            cin >> e[i];
        }

        sort(p.begin(), p.end());
        sort(e.begin(), e.end());

        long long sum = 0;
        int p1 = 0, p2 = 0;

        while(p1 < m && p2 < n) {
            if(p[p1] >= e[p2]) {
                sum += p[p1];
                p2++;
            }else{
                p1++;
            }
        }
        
        cout << sum << "\n";
    }
    return 0;
}

