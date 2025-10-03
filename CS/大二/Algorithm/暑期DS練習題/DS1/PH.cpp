#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;
    while(n--) {
        int k;
        cin >> k;
        int res = 0;
        for (int i = 2; i <= k; i++) {
            res = (res + 3) % i;
        }
        for (int i = 0; i < k; i++) {
            string str;
            cin >> str;
            if(i == res) {
                cout << str << endl;
            }
        }
    }
    return 0;
}
/*
< Josephus problem >
circular linked list
queue
iteration
*/
