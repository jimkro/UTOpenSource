#include<bits/stdc++.h>
using namespace std;

int main(){
    int n, empty;
    while (cin >> n){
        empty = n;
        
        while (empty / 3 > 0){
            empty -= 2;
            n++;
        }
        if (empty > 1) n++;
        cout << n << endl;
    }
}
