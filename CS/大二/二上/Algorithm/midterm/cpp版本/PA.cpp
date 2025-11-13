#include<bits/stdc++.h>
using namespace std;
int n;
vector<int> arr;

void output(){
    for(int x : arr) cout << x << " ";
    cout << "\n";
}

void merge(int l, int m, int r){
    int i = l, j = m + 1, k = 0;
    vector<int> tmp(r - l + 1);
    
    // 排序
    while(i <= m && j <= r) tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
    while(i <= m) tmp[k++] = arr[i++];
    while(j <= r) tmp[k++] = arr[j++];

    // 複製到原陣列
    copy(tmp.begin(), tmp.end(), arr.begin() + l);
}

void mergeSort(int l, int r){
    if(l >= r) return;
    int m = l + (r - l) / 2;
    mergeSort(l, m);
    mergeSort(m + 1, r);
    merge(l, m, r);
    output();
}

void solve(){
    arr.assign(n, 0); for(int i=0;i<n;i++) cin >> arr[i];
    mergeSort(0, n - 1);
    cout << "\n";
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    while(cin >> n) solve();
}