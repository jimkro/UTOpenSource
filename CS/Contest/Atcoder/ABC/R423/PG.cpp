#include<bits/stdc++.h>
using namespace std;

struct myVec{
    int n;
    vector<int> v;
    myVec(int n) : n(n), v(n){
        iota(v.begin(), v.end(), 0);
    }
    int& operator[](int index){
        index = (index % n + n) % n;
        return v[index];
    }
};

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    myVec v(10);
    v[-1] = 10000;
    cout << v[-1];
}