#include<bits/stdc++.h>
using namespace std;
#define ll long long
ll uppper = LLONG_MAX;
ll lower = 0L;
ll n, x, y, d;

ll large(ll w, ll num){
    ll gap = w - num * x;
    if(gap % d != 0 || gap / d > num) return -1;
    return gap / d;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> n >> x >> y;
    d = y - x;
    vector<ll> v(n); 
    for(int i=0;i<n;i++){
        cin >> v[i];
        // 可表示的重量範圍
        lower = max(lower, v[i] * x);
        upper = min(upper, v[i] * y);   
    }
    if(lower > upper){
        cout << "-1";
        return 0;
    }

}
