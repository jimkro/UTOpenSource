#include<bits/stdc++.h>
using namespace std;

vector<int> dp(501,0);

int gcd(int a,int b){
    return b ? gcd(b,a%b) : a;
}

int sum(int n){
    if(n == 1) return 0;
    int res = 0;
    int end = n & 1 ? n/2 : n/2 -1;
    for(int i=1;i <= end;i++){
        res += gcd(i,n);
    }
    res *= 2;
    return n & 1 ? res : res + gcd(n/2,n);
}

int solve(int G){
    if(dp[G] != 0) return dp[G];
    int ans = solve(G-1) + sum (G);
    dp[G] = ans;
    return dp[G];
}
int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int G;
    dp[2] = 1;    
    while(cin >> G){
        if(G == 0) break;   
        int ans = solve(G);
        cout << ans << "\n";
    }
}
