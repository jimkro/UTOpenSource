#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll mn = LLONG_MAX;
int n;
vector<int> nums;
void dfs(int i, ll sum){
    if(i == n){
        mn = min(mn, abs(sum));
        return;
    }

    dfs(i + 1, sum + nums[i]);
    dfs(i + 1, sum - nums[i]);
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    nums.resize(n);
    for(int& x : nums) cin >> x;
    dfs(0, 0LL);
    cout << mn;
}