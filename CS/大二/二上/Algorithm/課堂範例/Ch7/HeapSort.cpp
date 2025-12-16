#include <bits/stdc++.h>
using namespace std;

void printArray(const vector<int>& v){
    for(int x : v) cout << x << " ";
    cout << "\n";
}

// log(n)
void heapify(vector<int>& v, int n, int i){
    int largest = i;
    int left = i * 2 + 1;
    int right = i * 2 + 2;

    if(left < n && v[left] > v[largest]) largest = left;
    if(right < n && v[right] > v[largest]) largest = right;

    if(largest != i){
        swap(v[i], v[largest]);
        heapify(v, n, largest);
    }
}

// O(n * log(n))
void heapSort(vector<int>& v){
    int n = v.size();
    cout << "Original : "; printArray(v);

    // 把原始陣列調整成堆積形式
    for(int i = n / 2 - 1; i >= 0; i--) heapify(v, n, i);
    cout << "Heapify  : "; printArray(v); cout << "\n";

    // 把最大值移動到最後，並再次調整成堆積形式，直到只剩下一個點要處理時就結束
    for(int i = n - 1; i > 0; i--){
        swap(v[0], v[i]);
        heapify(v, i, 0);
        cout << "step " << n - i << " : ";
        printArray(v);
    }
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int n;
    while(cin >> n){
        vector<int> v(n); for(int& x : v) cin >> x;       
        heapSort(v);
    }
}