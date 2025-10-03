// classic Merge Sort
#include <bits/stdc++.h>
using namespace std;

void merge(vector<int>& arr, int l, int m, int r) {
    vector<int> tmp;  
    int i = l, j = m + 1;

    // 透過比較兩堆,小的先放進去來sort
    while(i <= m && j <= r){
        if(arr[i] <= arr[j]){
            tmp.push_back(arr[i]);
            i++;
        } else {
            tmp.push_back(arr[j]);
            j++;
        }
    }

    // 把剩下的補進去
    while(i <= m){
        tmp.push_back(arr[i]);
        i++;
    }

    while(j <= r){
        tmp.push_back(arr[j]);
        j++;
    }

    // 把排序好的元素放回原陣列
    for(int k = 0; k < tmp.size(); k++){
        arr[l + k] = tmp[k];
    }
}


void mergeSort(vector<int>& arr, int l, int r){
    if(l >= r) return;

    int m = l + (r - l) / 2;

    mergeSort(arr, l, m); // sort left half
    mergeSort(arr, m + 1, r); // sort right half
    merge(arr, l, m, r); // merge two sorted halves
}

int main(){
    int n; 
    while(cin >> n){
        // input
        vector<int> arr(n);
        for(int i = 0; i < n; i++) cin >> arr[i];
        
        // sort
        mergeSort(arr, 0, n - 1);

        // output
        for(int i = 0; i < n; i++) cout << arr[i] << " ";
        cout << "\n";
    }
    
    return 0;
}