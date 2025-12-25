#include <bits/stdc++.h>
using namespace std;
vector<int> v;

void printV(){
    for(int x : v){
        cout << x << " ";
    }
    cout << "\n";
}

void merge(int l, int m, int r){
    int i = l, j = m + 1;
    int A = m;
    int B = r;
    int tot = r - l + 1;
    vector<int> tmp;

    while(i <= A && j <= r){
        if(v[i] <= v[j]){
            tmp.push_back(v[i++]);
        }else{
            tmp.push_back(v[j++]);
        }
    }

    while(i <= A){
        tmp.push_back(v[i++]);
    }

    while(j <= B){
        tmp.push_back(v[j++]);
    }

    for(int k = l; k <= r; k++){
        v[k] = tmp[k - l];
    }

}

void mergeSort(int l, int r){
    if(l >= r) return;
    int m = l + (r - l) / 2;
    mergeSort(l, m);
    mergeSort(m+1, r);
    merge(l, m, r);
    printV();
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    long long n;
    int first = true;
    while(cin >> n){
        if(first) first = false;
        else cout << "\n";
        
        v.assign(n, 0);
        for(int& x : v) cin >> x;
        mergeSort(0, n - 1);
    }
}