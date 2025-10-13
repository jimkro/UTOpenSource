#include <bits/stdc++.h>

using namespace std;

int main() {
    
    int n,cnt = 1;
    while (cin >> n) {
        if(n < 0) break;

        int ans = (int)ceil(log2(n));   
        
        printf("Case %d: %d\n", cnt++, ans);
        
    }
    return 0;
}

