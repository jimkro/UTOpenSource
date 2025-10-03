#include<bits/stdc++.h>
using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b){
    if (a.second == b.second){
        return a.first > b.first;
    }
    return a.second < b.second;
}

int main(){
    string s;
    bool fl = 0;

    while (getline(cin, s)){
        if (fl) cout << endl;
        fl = 1;
        map<int, int> f;

        //如果map裡已有值會+1，沒有會增加此值並預設為0
        for (char c : s){
            f[(int)c]++;
        }

        //轉成vector，利用自訂的sort
        vector<pair<int, int>> fre(f.begin(), f.end());
        sort(fre.begin(), fre.end(), cmp);

        for (auto t : fre){
            cout << t.first << " " << t.second << "\n";
        }
    }
}