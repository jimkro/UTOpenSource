#include <bits/stdc++.h>
using namespace std;

void printArray(const vector<int>& v) {
    for (int x : v) cout << x << " "; cout << "\n";
}

void countSort(vector<int>& v, int exp) {
    int n = v.size();
    vector<int> res(n);
    int count[10] = {0};

    for (int i = 0; i < n; i++) count[(v[i] / exp) % 10]++;
    for (int i = 1; i < 10; i++) count[i] += count[i - 1]; // prefix

    for (int i = n - 1; i >= 0; i--) {
        int digit = (v[i] / exp) % 10;
        res[count[digit] - 1] = v[i];
        count[digit]--;
    }

    v = res;
}

void radixSort(vector<int>& v) {
    int mx = *max_element(v.begin(), v.end());
    for (int exp = 1; mx / exp > 0; exp *= 10) countSort(v, exp);
}


int main() {
    vector<int> v = {170, 45, 75, 90, 802, 24, 2, 66};

    cout << "Original : "; printArray(v);
    radixSort(v);
    cout << "Sorted   : "; printArray(v);
    
    return 0;
}