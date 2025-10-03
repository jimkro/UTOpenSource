/*
解題想法
麻煩但不難
用字串做對照
ta = table

注意:
歌曲一定要讀整行不能讀字串
不然會讀不到空行
*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    string order, tmp, s = "cdefgabCDEFGAB";
    int ans[10];
    int cases;
    string ta[14];
    ta[0] = "0111001111";
    ta[1] = "0111001110";
    ta[2] = "0111001100";
    ta[3] = "0111001000";
    ta[4] = "0111000000";
    ta[5] = "0110000000";
    ta[6] = "0100000000";
    ta[7] = "0010000000";
    ta[8] = "1111001110";
    ta[9] = "1111001100";
    ta[10] = "1111001000";
    ta[11] = "1111000000";
    ta[12] = "1110000000";
    ta[13] = "1100000000";

    cin >> cases;
    cin.ignore();

    while (cases--) {
        //歸零ans
        fill(begin(ans), end(ans), 0);
        //放十個空格，才能讓第一個音符正常運算(想看看下面if的成立狀況)
        tmp = "          ";
        getline(cin, order);
        //如果是空字串for就不會動，所以不另外討論

        for (int i = 0; i < order.size(); i++){
            char c = order[i];
            for (int j = 0; j < 10; j++){
                //沒按住 && 現在要按才算
                if(tmp[j] != '1' && ta[s.find(c)][j] == '1'){
                    ans[j]++;
                }
            }
            tmp = ta[s.find(c)];
        }

        for (int i = 0; i < 10; i++){
            cout << ans[i] << " ";
        }
        cout << endl;
    }
}