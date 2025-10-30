/*
解題想法
直接從2開始炸開
再比誰的成本小

我是用(成本,底數)為一組去存
這樣C++可以直接用成本sort
*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    int arr[36] = {};
    vector<pair<int, int>> ans;
    int cases, nums;
    long long n, tmp, sum;
    cin >> cases;

    for (int z = 1; z <= cases; z++){
        for (int i = 0; i < 36; i++){
            cin >> arr[i];
        }
        cin >> nums;

        cout << "Case " << z << ":\n";
        while (nums--){
            ans.clear();
            cin >> n;

            for (int i = 2; i < 37; i++){
                tmp = n;
                sum = 0;

                while (tmp != 0){
                    //除出來的餘數就是那個字的成本在arr裡的所在位置
                    sum += arr[tmp % i];
                    tmp /= i;
                }
                ans.push_back({sum, i});
            }

            sort(ans.begin(), ans.end());

            cout << "Cheapest base(s) for number " << n << ":";
            for (int i = 0; i < ans.size(); i++){
                if (ans[i].first == ans[0].first){
                    cout << " " << ans[i].second;
                }else {
                    break;
                }
            }
            cout << endl;
        }
        //每個case間要空行(最後一個不用所以用if)
        if (z < cases) cout << endl;
    }
}