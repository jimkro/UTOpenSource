/*
解題想法
由內而外一層一層炸開檢查
只要有一個不對就結束
*/

#include <bits/stdc++.h>
using namespace std;

int main() {
    int cases, m, n, q, x, y, in;
    char c;
    bool f;
    cin >> cases;

    while (cases--) {
        cin >> m >> n >> q;
        cout << m << " " << n << " " << q << endl;
        string arr[m];

        for (int i = 0; i < m; i++) {
            cin >> arr[i];
        }

        while (q--) {
            cin >> x >> y;
            in = 0;
            f = true;
            c = arr[x][y];

            while (f) {
                // 確定在範圍內
                if (!(x - in >= 0 && x + in < m && y - in >= 0 && y + in < n)) {
                    f = false;
                    break;
                }

                for (int i = -in; i <= in; i++) {
                    // 上下左右整排逐一檢查
                    if (c != arr[x - in][y + i] || c != arr[x + in][y + i] || c != arr[x + i][y - in] || c != arr[x + i][y + in]) {
                        f = false;
                        break;
                    }
                }
                if (f) in++;
            }
            cout << in * 2 - 1 << endl;
        }
    }
}