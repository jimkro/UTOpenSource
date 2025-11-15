// AC
#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n; cin >> n;
    int a; cin >> a;
    int tmp;
    bool flag = false;
    long long prev = 0, suff = 0;
    for(int i=0;i<n;i++){
        cin >> tmp;
        if(i == 0 && tmp == a) flag = true;
        if(tmp < a) prev++;
        else if(tmp > a) suff++;
    }
    if(flag){
        cout << "-7\n";
    }
    int b = a;
    if(suff > prev) b++;
    else b--;
    cout << b << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}