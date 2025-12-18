#include <bits/stdc++.h>
using namespace std;

void Hanoi(int n, int from, int to){
    if(n == 1){
        cout << from << " " << to << "\n";
        return;
    }
    int other = 6 - from - to;
    Hanoi(n-1, from, other);
    Hanoi(1, from, to);
    Hanoi(n-1, other, to);
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int n; cin >> n;
    int times = (int)pow(2, n) - 1;
    cout << times << "\n";
    Hanoi(n, 1, 3);
}