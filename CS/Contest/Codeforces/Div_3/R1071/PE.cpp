#include <bits/stdc++.h>
#define int long long
using namespace std;

void solve(){
    int N, X, Y; cin >> N >> X >> Y;
    string win; cin >> win;
    
    vector<int> p(N);
    int sum_p = 0;
    for(int& x : p){
        cin >> x;
        sum_p += x;
    }

    // 總票數不夠
    if(sum_p > X + Y){
        cout << "NO\n";
        return;
    }
   
    bool has0 = false, has1 = false;
    int cntX = 0, cntY = 0;
    
    for(int i = 0; i < N; i++){
        if(win[i] == '0'){
            has0 = true;
            cntX += p[i] / 2 + 1;
        }else{
            has1 = true;
            cntY += p[i] / 2 + 1;
        }
    }

    // 贏家手上的票必須夠支付「勝選最低票數」
    if(X < cntX || Y < cntY) cout << "NO\n";
    else{
        if(has0 && has1){ // 混合贏家
            cout << "YES\n";
        }else{ // 單一贏家
            if(has0){ // A 全贏
                if(X < Y + N) cout << "NO\n";
                else cout << "YES\n";
            }else{ 
                // B 全贏
                if(Y < X + N) cout << "NO\n";
                else cout << "YES\n";
            }
        }
    }
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while(T--) solve();
}