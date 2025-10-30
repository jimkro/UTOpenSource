/*
解題想法:
只要掉下去，就紀錄那個點是危險的(我稱為墓碑w)

每次移動都要判斷
1.會不會掉出去
  ->會:
    - 本來在墓碑上:返回墓碑並原地進行下一動
    - 不在墓碑上:留下墓碑，輸出LOST
  ->不會:
    - 本來在墓碑上:紀錄已離開墓碑
2.是不是走到墓碑上了
是 -> 紀錄dan為true(危險的英文的縮寫)

順序要對不然會錯誤
*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    //分別是，x.y最大值，現在的x.y，現在面向的方位，移動前的x.y
    int dx, dy, x, y, now, tx, ty;
    //指令和初始面向方位
    string ord, face;
    //是不是掉出去了&是不是站在前人的墓碑上
    bool f, dan;
    //方位代號，左轉就是往左一格，右轉就是往右一格
    vector<string> ta = {"E", "S", "W", "N"};
    //紀錄有人掉下去的地方
    vector<pair<int, int>> hol;

    cin >> dx >> dy;

    while(cin >> x >> y >> face >> ord){
        dan = false;
        f = false;
        if (face == "E") now = 0;
        else if (face == "S") now = 1;
        else if (face == "W") now = 2;
        else now = 3;

        for (int i = 0; i < ord.size(); i++){
            //紀錄上一點
            tx = x;
            ty = y;

            switch(ord[i]){

                case 'F':
                    if (ta[now] == "E") x++;
                    else if (ta[now] == "W") x--;
                    else if (ta[now] == "N") y++;
                    else y--;

                    //移動後在邊界外
                    if (x > dx || y > dy || x < 0 || y < 0){
                        x = tx;
                        y = ty;
                        //如果在墓碑上，就不會掉下去，繼續下一動
                        if (dan) continue;
                        //掉下去了，紀錄墓碑位置
                        hol.push_back(make_pair(x, y));
                        f = true;
                        break;
                    }else dan = false;  //移動後沒掉出去，代表已經離開墓碑位置
                    break;

                case 'R':
                    dan = false;
                    now = (now + 1) % 4;
                    break;

                case 'L':
                    dan = false;
                    now = (now + 3) % 4;
                    break;
            }

            if (f) break; //掉出去了

            //判斷現在是不是在墓碑上
            if (find(hol.begin(), hol.end(), make_pair(x, y)) != hol.end()){
                dan = true;
                continue;
            }
        }
        cout << x << " " << y << " " << ta[now];
        if (f) cout << " LOST";
        cout << "\n";
    }
}