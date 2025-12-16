// Author : Jimkro
#include<bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    double x1, y1, x2, y2, x3, y3, x4, y4;
    while(cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3 >> x4 >> y4){
        double sameX = x1, sameY = y1, sumX = x1 + x2 + x3 + x4, sumY = y1 + y2 + y3 + y4;
        // 先找共用的點是哪一個
        if((x2 == x3 && y2 == y3) || (x2 == x4 && y2 == y4)){ // double 直接用等於不太好, 但 Uva 上會過就可以偷偷省下來了
            sameX = x2;
            sameY = y2;
        }
        printf("%.3f %.3f\n", sumX - 3 * sameX, sumY - 3 * sameY);
    }
    return 0;
}