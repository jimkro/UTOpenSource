#include <bits/stdc++.h>
using namespace std;

int main() {
    // ios::sync_with_stdio(false);cin.tie(nullptr);

    string line;
    while (getline(cin, line)) {
        if (line.empty()) continue;
        stringstream ss(line);
        string token;
        vector<char> tree;
        unordered_map<char,int> mp;
        int idx = 0;

        while (ss >> token) {
            if(token[0] != '0') mp[token[0]] = idx;
            tree.push_back(token[0]);
            idx++;
        }
        vector<string> encode(idx,"");

        // link 
        for (int i = 0; i < idx; i++) {

            int leftIdx = 2 * i + 1;
            int rightIdx = 2 * i + 2;

            if (leftIdx < idx){
                encode[leftIdx] = encode[i] + '0';
            }

            if (rightIdx < idx){
                encode[rightIdx] = encode[i] + '1';
            }
        }
        
        // for(auto& [key, value] : mp){
        //     cout << key << " -> " << value << endl;
        // }
        
        // for(int i=0;i<64;i++){
        //     cout << i << " -> " << encode[i] << endl;
        // }

        int cases;
        cin >> cases;

        
        while(cases--){
            string input;
            cin >> input;

            if(!isdigit(input[0])){
                for(char& c : input){
                    cout << encode[mp[c]];
                }
                cout << "\n";
            }else{
                int curr = 0;
                for(char& c : input){
                    int d = c == '0' ? 1 : 2;
                    int next = 2 * curr + d;
                    
                    if(tree[curr] != '0' && (next >= idx || tree[next] == '0')){ // 代表找到了要輸出和重製了
                        cout << tree[curr];
                        curr = d;
                    }else{
                        curr = next;
                    }
                    
                }
                if(curr != 0){
                    cout << tree[curr];
                }
                cout << "\n";
            }
        }
    }
    return 0;
}
