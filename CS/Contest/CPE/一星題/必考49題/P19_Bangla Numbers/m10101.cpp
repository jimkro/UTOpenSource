/*
解題想法(應該算遞迴?)
用一堆if做英文插入
先把10000000以上的數字拿去再插一次英文
(例如一萬看成10個一千，把10拿去做英文插入)
然後只留下10000000以下的數字，再用一樣的邏輯做到底
要注意都是用if而非else if
因為else if只會做第一個符合的條件

注意:輸入0的情況要單獨討論
*/

#include<bits/stdc++.h>
using namespace std;

void ban(long long n){
    if (n >= 10000000){
        ban(n / 10000000);
        cout << " kuti";
        n %= 10000000;
    }
    if (n >= 100000){
        ban(n / 100000);
        cout << " lakh";
        n %= 100000;
    }
    if (n >= 1000){
        ban(n / 1000);
        cout << " hajar";
        n %= 1000;
    }
    if (n >= 100){
        ban(n / 100);
        cout << " shata";
        n %= 100;
    }
    if (n != 0){
        cout << " " << n;
    }
}

int main(){
    long long n;
    int t = 1;
    while (cin >> n){
        cout << t << ".";
        t++;
        if (n == 0) {
            cout << " " << n <<"\n";
            continue;
        }
        ban(n);
        cout << "\n";
    }
}