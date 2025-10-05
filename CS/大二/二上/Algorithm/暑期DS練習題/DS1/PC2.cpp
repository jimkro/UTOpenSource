#include <bits/stdc++.h>
using namespace std;

int main(){
    string s1,s2;

    while(cin >> s1 >> s2){
        int n = s1.size();
        int l = 0, r = 0; // 預設是 0,0 這樣就算兩個字串完全一樣也只會s[0]跟s[0]交換而已，也不會有問題 !

        // 從左右邊找有不同的就紀錄index，然後直接交換，然後靠檢查字串相等就可以判斷這樣做對不對了 !
        for(int i=0;i<n;i++){
            if(s1[i] != s2[i]){
                l = i;
                break;
            }
        }

        for(int i=n-1;i>=0;i--){
            if(s1[i] != s2[i]){
                r = i;
                break;
            }
        }

        swap(s1[l],s1[r]);
        if(s1 == s2) cout << "True\n";
        else cout << "False\n";
    }
}