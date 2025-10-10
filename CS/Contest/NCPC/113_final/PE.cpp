#include<bits/stdc++.h>
using namespace std;

int main(){
    int T; cin >> T;
    
    while(T-->0){
        string sx, sy, sa, sb; cin >> sx >> sy >> sa >> sb;
        if(sx.size() > 80 || sy.size() > 80 || sa.size() > 2 || sb.size() > 2 || stoi(sa) + stoi(sb) != 30 || stoi(sa) < 20 || stoi(sb) < 8){
            cout << "Wrong Input\n";
            continue;
        }

        if(sx.size() > 4 || sy.size() > 4){
            cout << "30-Day Pass\n";
            continue;
        }

        int x = stoi(sx), y = stoi(sy), a = stoi(sa), b = stoi(sb);
        int sum = x * a + y * b;
        if(sum > 1200){
            cout << "30-Day Pass\n";
        }else if(sum < 1200){
            cout << "Pay As You Go\n";
        }else{
            cout << "Equally Good\n";
        }
    }
}


