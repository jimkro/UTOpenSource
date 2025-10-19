#include<bits/stdc++.h>
using namespace std;

void solve(){
    int N = 1, p;

    cout << "Q 2\n";
    cin >> p;
    N *= pow(2,p);

    cout << "Q 3\n";
    cin >> p;
    N *= pow(3,p);

    cout << "Q 5\n";
    cin >> p;
    N *= pow(5,p);

    cout << "Q 7\n";
    cin >> p;
    N *= pow(7,p);

    cout << "A " << N;
}

int main(){
    // ios::sync_with_stdio(0); cin.tie(0);

    solve();
}