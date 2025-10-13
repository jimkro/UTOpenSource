#include <bits/stdc++.h>
using namespace std;

void printAns(vector<int>& v){
    for(int x : v) cout << x << " ";
    cout << "\n";
}

void merge(vector<int>& v,int l, int m, int r){
    // 暫存答案
    vector<int> tmp(r - l + 1);
    // idx們
    int i = l, j = m + 1, t = 0;

    // 小的先放
    while(i <= m && j <= r) (v[i] <= v[j]) ? (tmp[t++] = v[i++]) : (tmp[t++] = v[j++]);
    while(i <= m) tmp[t++] = v[i++];
    while(j <= r) tmp[t++] = v[j++];

    // 複製到原本陣列裡面
    for(int k = 0; k < tmp.size(); k++) v[l + k] = tmp[k];
}

void mergeSort(vector<int>& v,int l, int r){
    if(l >= r) return;
    int m = l + (r - l) / 2;

    mergeSort(v,l,m);
    mergeSort(v,m+1,r);
    merge(v,l,m,r);
    printAns(v);
}



int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int n;
    while(cin >> n){
        vector<int> v(n); for(int i=0;i<n;i++) cin >> v[i];
        mergeSort(v,0,n-1);
        cout << "\n";
    }
}