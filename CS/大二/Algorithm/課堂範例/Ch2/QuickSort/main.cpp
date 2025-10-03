#include<bits/stdc++.h>
using namespace std;

void quickSort(vector<int>& arr, int l, int r) {
    if (l >= r) return;

    int pivot = arr[l];
    int i = l, j = r;

    while (i <= j) {
        while (i <= r && arr[i] < pivot) i++;   // 找到 >= pivot 的
        while (j >= l && arr[j] > pivot) j--;   // 找到 <= pivot 的

        if (i <= j) swap(arr[i++], arr[j--]);
    }

    // 現在 arr[l..j] <= pivot, arr[i..r] >= pivot
    quickSort(arr, l, j);
    quickSort(arr, i, r);
}


int main(){

    int n;

    while(cin >> n){
        // input
        vector<int> arr(n);
        for(int i=0; i<n; i++) cin >> arr[i];

        // quick sort
        quickSort(arr, 0, n-1);

        // output
        for(int i=0; i<n; i++) cout << arr[i] << " ";
        cout << "\n";
    }
    return 0;
}