#include <bits/stdc++.h>

using namespace std;

int main() {
    int N,K;
    while (cin >> N >> K) {
        vector<int> v(N);
        vector<int> diff(N-1);
        for(int i=0;i<N;i++){
            cin >> v[i];
        }
        sort(v.begin(), v.end());
        for(int i=0;i<N-1;i++){
            diff[i] = v[i+1] - v[i];
        }
        sort(diff.begin(), diff.end());
        int sum = accumulate(diff.begin(), diff.begin() + K, 0);
        cout << sum << endl;
    }
    return 0;
}
