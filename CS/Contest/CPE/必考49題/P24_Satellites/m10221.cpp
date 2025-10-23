/*
解題想法(其實根本難在數學)
我選擇分鐘轉度數
1度 = 60分鐘
1分鐘 = 1/60度
(不要問我為甚麼，都是AI說的)
*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    double s, a, chord, arc;
    string d;

    while (cin >> s >> a >> d){
        //要加上地球半徑
        s += 6440.0;
        //分鐘換度數
        if (d == "min"){
            a /= 60;
        }
        //換同位角
        while (a >= 360){
            a -= 360;
        }
        //換成90度內
        if (a > 180) a = 360 - a;

        cout << fixed << setprecision(6);
        cout << s * a * M_PI/180 << " " << s * sin(a/2*M_PI/180)*2 << "\n";
    }
}