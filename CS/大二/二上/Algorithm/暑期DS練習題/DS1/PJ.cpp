#include <bits/stdc++.h>

using namespace std;

int main() {
    int m, n;
    while(cin >> m >> n) {
        cout << (int)(pow(2,n) - 1) * m << endl;
    }
    return 0;
}
