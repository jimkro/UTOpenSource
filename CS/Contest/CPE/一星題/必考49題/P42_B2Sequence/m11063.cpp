/*
解題想法
總之就是暴力解...建表...
*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    int len, cases = 0;
    bool f;

    while (cin >> len){
        vector<int> arr(len);
        vector<bool> check(20000, false);
        cases++;
        f = 0;

        for (int i = 0; i < len; i++){
            cin >> arr[i];
            if (arr[i] < 1) f = 1;
        }
        if (f){
            cout << "Case #" << cases << ": It is not a B2-Sequence.\n\n";
            continue;
        }

        for (int i = 0; i < len; i++){
            for (int j = i; j < len; j++){
                if (check[arr[i] + arr[j]] || (arr[i] >= arr[j] && j > i)){
                    f = 1;
                    break;
                }else{
                    check[arr[i] + arr[j]] = true;
                }
            }
            if (f) break;
        }

        if (f) cout << "Case #" << cases << ": It is not a B2-Sequence.\n\n";
        else cout << "Case #" << cases << ": It is a B2-Sequence.\n\n";
        
    }
}