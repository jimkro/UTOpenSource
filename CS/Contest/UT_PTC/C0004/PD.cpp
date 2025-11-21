#include<bits/stdc++.h>
using namespace std;
#define int long long

// 解一元二次方程式計算雨量 F
double calc(double L, double K, double T1, double H_target){
    double a = 1.0;
    double b = -(H_target + K * T1);
    double c = K * L * T1;
    
    double delta = b * b - 4 * a * c;
    if(delta < 0) delta = 0;

    // 取較大的根
    return (-b + sqrt(delta)) / (2 * a);
}

void solve(){
    double L, K, T1, T2, H; cin >> L >> K >> T1 >> T2 >> H;

    if(H < L){
        // 未達破洞，沒漏水
        cout << H << " " << H << "\n";
    }else if(H > L){
        // 高於破洞，雨停時必定在 H + K*T2
        double target = H + K * T2;
        double ans = calc(L, K, T1, target);
        cout << ans << " " << ans << "\n";
    }else{
        // H == L
        // min: 剛好下到 L 停
        double min_ans = L;
        // max: 雨停時在 L + K*T2，剛好漏光回來
        double target = L + K * T2;
        double max_ans = calc(L, K, T1, target);
        cout << min_ans << " " << max_ans << "\n";
    }
}

signed main(){
    ios::sync_with_stdio(0); cin.tie(0);
    cout << fixed << setprecision(6);
    int T; cin >> T;
    while(T--) solve();
    return 0;
}