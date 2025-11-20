#include<bits/stdc++.h>
using namespace std;
using ll = long long;
int l, r;
vector<int> primes;
vector<bool> isPrime;
unordered_set<int> st;
vector<int> ac;
void init(){
    const vector<int> vv = {113,131,197,199,311,337,373,719,733,919,971,991,1193,1931,3119,3779,7793,7937,9311,9377,11939,19391,19937,37199,39119,71993,91193,93719,93911,99371,193939,199933,319993,331999,391939,393919,919393,933199,939193,939391,993319,999331};
    ac.assign(1000001, 0);
    for(const int x : vv) ac[x]++;
    for(int i = 100; i <= 1000000; i++){
        ac[i] += ac[i-1];
    }
}

void solve(){
    ll res = ac[r] - ac[l-1];
    if(res == 0){
        cout << "No Circular Primes.\n";
    }else if(res == 1){
        cout << "1 Circular Prime.\n";
    }else{
        cout << res << " Circular Primes.\n";
    }
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    init();
    while(cin >> l){
        if(l == -1) break;
        cin >> r;
        solve();
    }
}