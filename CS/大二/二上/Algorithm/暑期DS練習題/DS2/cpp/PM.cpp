#include<bits/stdc++.h>

using namespace std;

int main(){
    int k,limit,cnt = 1;
    while(cin >> k >> limit){
        if(k == -1 && limit == -1) break;
        int terms = 1;
        int original_k = k;
        while(k != 1){
            
            if(k % 2 == 1){
                k = (3 * k + 1);
            }else{
                k /= 2;
            }

            if(k > limit){
                break;
            }
            terms++;
        }

        printf("Case %d: K = %d, limit = %d, number of terms = %d\n",cnt,original_k,limit,terms);
        cnt++;
    }   
}