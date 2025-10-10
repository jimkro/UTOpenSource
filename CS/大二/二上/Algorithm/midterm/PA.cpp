#include <bits/stdc++.h>
using namespace std;

void printAns(vector<int>& v){
    for(int x : v){
        cout << x << " ";
    }
    cout << "\n";
}

void merge(vector<int>& v,int l, int m, int r){
    vector<int> tmp;
    int i = l, j = m + 1;
    while(i <= m && j <= r){
        if(v[i] <= v[j]){
            tmp.push_back(v[i]);
            i++;
        }else{
            tmp.push_back(v[j]);
            j++;
        }
    }

    while(i <= m){
        tmp.push_back(v[i]);
        i++;
    }

    while(j <= r){
        tmp.push_back(v[j]);
        j++;
    }
    int t = 0;
    for(int k = l;k<=r;k++){
        v[k] = tmp[t];
        t++;
    }
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
    // ios::sync_with_stdio(0); cin.tie(0);

    int n;
    while(cin >> n){
        vector<int> v(n); for(int i=0;i<n;i++) cin >> v[i];
        mergeSort(v,0,n-1);
        cout << "\n";
    }
}