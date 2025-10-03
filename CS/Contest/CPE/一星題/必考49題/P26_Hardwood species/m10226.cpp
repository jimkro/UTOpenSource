/*
解題想法
map會自動排key的字典序
但據說用unorder_map再轉vector<string, int>再sort比較快ww
*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    int cases, sum;
    string s;
    cin >> cases;
    //忽略換行符號和空行
    cin.ignore();
    cin.ignore();

    while (cases--){
        sum = 0;
        map<string, int> arr;
        while (getline(cin, s) && !s.empty()){
            arr[s]++;
            sum++;
        }

        cout << fixed << setprecision(4);
        for (const auto& pair : arr) {
            cout << pair.first;
            cout << " " << (float)(pair.second * 100.0/sum) << endl;
        }
    }
}