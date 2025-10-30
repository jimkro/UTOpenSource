#include<bits/stdc++.h>
using namespace std;

int main(){
    int a, b;
    while (cin >> a >> b){
        int ans = 0;
        cout << a << " " << b << " ";

        for (int i = min(a, b); i <= max(a, b); i++){
            int count = 0;
            int n = i;
            while (n != 1){
                if (n % 2 == 0) n/= 2;
                else n = 3*n + 1;
                count++;
            }
            if (count > ans) ans = count;
        }
        cout << ans+1 << "\n";
    }
}