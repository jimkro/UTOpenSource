#include<bits/stdc++.h>
using namespace std;

long long cal(const int i, vector<int>& arr){
    // 計算操作次數
    long long res = 0;

    // 檢查並修改值(若不修改右邊那項可能會被重複計算兩次)
    if(arr[i - 1] >= arr[i]){
        res += arr[i - 1] - arr[i] + 1;
        arr[i - 1] = arr[i] - 1;
    }

    if(arr[i + 1] >= arr[i]){
        res += arr[i + 1] - arr[i] + 1;
        arr[i + 1] = arr[i] - 1;
    }

    return res;
}

void solve(){
    // 輸入
    int n; cin >> n;
    vector<int> arr(n); for(int i = 0; i < n; i++) cin >> arr[i];
    if(n % 2 == 0) arr.push_back(0); // 在後面補零方便計算,才不會存取到越界的值

    long long res = 0;
    int mx = 1;

    // 更新偶數位(1-indexed)的值
    for(int i = 0; i < arr.size() - 1; i++){
        mx = max(mx, arr[i]);
        if(i % 2 == 1) arr[i] = mx;
    }
    
    // 檢查偶數位(1-indexed)
    for(int i = 0; i < arr.size() - 1; i++) if(i % 2 == 1) res += cal(i,arr);

    // 輸出
    cout << res << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int T; cin >> T;
    while(T--) solve();
}