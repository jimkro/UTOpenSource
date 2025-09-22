#include <bits/stdc++.h>

using namespace std;

int main(){
    string line;
    list<string> loveBook;
    unordered_map<string, list<string>::iterator> wordMap;
    
    while (getline(cin, line)){
        if (line == "0") break;  // 結束條件

        int len = line.size();

        vector<string> result;  // 結果

        string word = ""; // 當前單詞

        for (int i = 0; i <= len; ++i){
            char ch = (i < line.size() ? line[i] : '\0'); // 確保最後也能處理

            if (isalpha(ch)){
                word += ch;
            }else{
                if (!word.empty()){
                    // 處理英文字
                    
                    if (wordMap.find(word) == wordMap.end()){ // 第一次出現
                        result.push_back(word);
                        loveBook.push_front(word);
                        wordMap[word] = loveBook.begin();
                    }else{ // 出現過
                        
                        // 找位置
                        auto it = wordMap[word];          // 拿到 list 中 iterator
                        int pos = distance(loveBook.begin(), it);  // 算出 index
                        result.push_back(to_string(pos + 1));      // 題目是從 1 開始數

                        // 移動到最前
                        loveBook.erase(wordMap[word]);
                        loveBook.push_front(word);
                        wordMap[word] = loveBook.begin();
                    }
                    word.clear();
                }

                // 非字母直接加入輸出
                if (ch != '\0'){
                    string s(1, ch);
                    result.push_back(s);
                }
            }
        }

        // 輸出結果
        for (const string& s : result){
            cout << s;
        }
        cout << endl;
    }
    return 0;
}
