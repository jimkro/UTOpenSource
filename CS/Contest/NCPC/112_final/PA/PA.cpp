// 公開及隱藏測資皆已通過 !!!
#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int T; cin >> T;

    while(T--){
        int end, pSz; cin >> end >> pSz;
        vector<pair<int,int>> players(pSz, pair<int,int>{0,0}); // Pi 的 {目前位置, 下個 must stop 的 idx}

        // mustStop 輸入
        vector<int> mustStop;
        int tmp;
        while(cin >> tmp && tmp != 0){
            mustStop.push_back(tmp);
        }
        int msSz = mustStop.size();

        int dice, playerIdx = 0;
        int winner = 0;

        while(cin >> dice && dice != 0){
            if(winner != 0) continue; // 已經找到贏家了，所以就耍廢讀完輸出
            
            auto [curr, msIdx] = players[playerIdx];
            int next = curr + dice;

            if((msIdx >= msSz || next <= mustStop[msIdx]) && next <= end){
                players[playerIdx].first = next;
                if(msIdx < msSz && next == mustStop[msIdx]){
                    players[playerIdx].second++;
                }
            }
            
            // 到終點了
            if(players[playerIdx].first == end){
                winner = playerIdx + 1;
            }

            // 換下個人
            playerIdx = (playerIdx + 1) % pSz;
        }
        
        // 測試
        // for(int i=0;i<pSz;i++){
        //     cout << (i+1) << " on " << players[i].first << "\n";
        // }
        

        // 輸出
        cout << winner << "\n";

    }
}