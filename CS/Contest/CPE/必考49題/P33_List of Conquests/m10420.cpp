/*
解題想法
這題機車的是隱藏測資裡兩人間可能有空行
我是如果讀到空行就把減少的cases加回來
其他應該都是語法上的東東了
*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    int cases,index;
    string s, contry;
    unordered_map<string, int> arr;
    cin >> cases;
    cin.ignore();

    while (cases--){
        getline(cin, s);
        if(s == "") {
            cases++;
            continue;
        }
        //國家是一個單字，所以找第一個空格位置
        index = s.find(' ');
        //第一個空格前的字串就是國家名
        contry = s.substr(0, index);
        arr[contry]++;
    }

    //轉vector做排序
    vector<pair<string, int>> ans(arr.begin(), arr.end());
    sort(ans.begin(), ans.end());

    for (auto pair : ans){
        cout << pair.first << " " << pair.second << endl;
    }
}