#include<bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int n;

    while(cin >> n && n != 0){
        int a, b, c, d; cin >> a >> b >> c >> d;

        vector<long long> v(n+2);
        v[0] = 1, v[n+1] = INT_MIN; // v[n+1] 故意設很小讓他可以自己賣，不需要if去判斷特例

        // 先算成 y
        for(int i=1;i<=n;i++) v[i] = (a * v[i-1] + b) % c;

        // 再算成 x
        for(int i=1;i<=n;i++) v[i] = v[i] % d - d / 2;

        int l = 0; // 目前這筆 sum 的左界(即買入點)
        int B = 0, S = 0;
        long long P = 0, sum = 0;

        for(int r = 1; r<=n+1; r++){

            if(sum + v[r] < 0){ // 如果加上去會小於0那不如重新開始(sum = 0)，然後更新 l = r
                sum = 0;
                l = r;
            }else{
                sum += v[r]; // 如果沒事就加看看
            }

            // 更新 P
            if(sum > P){
                P = sum;
                S = r;
                B = l;
            }
        }

        // 輸出
        cout << P << " " << B << " " << S << "\n";
    }
}