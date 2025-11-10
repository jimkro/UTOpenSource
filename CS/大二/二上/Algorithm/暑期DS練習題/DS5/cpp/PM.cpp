// AC
#include<bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    string line;
    while(getline(cin, line)){
        if(line.empty()) continue; //遇到空行要跳過
        
        // 樹
        vector<char> tree;
        char token;
        stringstream ss(line);
        while(ss >> token) tree.push_back(token);
        int n = tree.size();
        
        unordered_map<char,string> mp; // 拿「字元」去對應「解碼後的字串」
        vector<string> encode(n,""); // 輔助生成編碼
        
        // 建encode表 (表示每一個節點的encode)
        for(int i=0;i<n;i++){
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            // 字母
            if(tree[i] != '0') mp[tree[i]] = encode[i];
            // 幫他的左右加字元
            if(left < n) encode[left] = encode[i] + "0";
            if(right < n) encode[right] = encode[i] + "1";
        }

        // 處理 query
        int T; cin >> T;
        while(T--){
            string op; cin >> op;
            if(isdigit(op[0])){
                int curr = 0;
                for(char& c : op){
                    int d = c - '0' + 1; // 看是左還右
                    int next = 2 * curr + d;
                    
                    // 找到字母了
                    if(tree[curr] != '0'){
                        cout << tree[curr];
                        curr = d; // 原本以為是這個組編碼的, 但其實他是下一組的開始, 所以就把 curr 重製成 d
                    }else{
                        curr = next;
                    }
                    
                }
                // 最後一個要補輸出(因為op讀完了, 不會遇到上面的字母判斷了)
                if(curr != 0) cout << tree[curr];
            }else{
                // 直接用剛剛算好了的答案
                for(char c : op) cout << mp[c];
            }
            cout << "\n";
        }
    }
}