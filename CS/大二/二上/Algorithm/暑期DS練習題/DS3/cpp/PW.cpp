#include <bits/stdc++.h>

using namespace std;

int precedence(char op){
    if (op == '+' || op == '-') return 1;
    if (op == '*' || op == '/') return 2;
    return 0;
}

vector<string> toSuffix(const string& infix) {
    stack<char> operators;
    vector<string> suffix;
    string num;

    for (char c : infix) {
        if (isdigit(c)) {
            num += c;
        } else {
            if (!num.empty()) {
                suffix.push_back(num);
                num.clear();
            }

            if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.empty() && operators.top() != '(') {
                    suffix.push_back(string(1, operators.top()));
                    operators.pop();
                }
                operators.pop(); // pop '('
            } else { // operator
                while (!operators.empty() && operators.top() != '(' &&
                       precedence(c) <= precedence(operators.top())) {
                    suffix.push_back(string(1, operators.top()));
                    operators.pop();
                }
                operators.push(c);
            }
        }
    }

    if (!num.empty()) {
        suffix.push_back(num);
    }

    while (!operators.empty()) {
        suffix.push_back(string(1, operators.top()));
        operators.pop();
    }

    return suffix;
}

bool isNumber(const string& token) {
    return !token.empty() && all_of(token.begin(), token.end(), ::isdigit);
}

bool isOperator(const string& token) {
    return token.size() == 1 && (token[0] == '+' || token[0] == '-' || token[0] == '*' || token[0] == '/');
}
int main() {
    ios::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);

    string infix_expression;
    cin >> infix_expression;

    vector<string> suffix_expression = toSuffix(infix_expression);

    // 輸出後序表達式
    for (const auto& t : suffix_expression) cout << t << " ";
    cout << "\n";

    // 逐步簡化後序表達式並輸出
    while (suffix_expression.size() > 1) {
        bool simplified = false;
        int size = suffix_expression.size();
        for (int i = 0; i + 2 < size; i++) {

            if (isNumber(suffix_expression[i]) && isNumber(suffix_expression[i+1]) && isOperator(suffix_expression[i+2])) {
                string op = suffix_expression[i+2];
            
                int a = stoi(suffix_expression[i]);
                int b = stoi(suffix_expression[i+1]);
                int res = 0;
                
                switch (op[0]) {
                    case '+': res = a + b; break;
                    case '-': res = a - b; break;
                    case '*': res = a * b; break;
                    case '/': res = a / b; break;
                }

                // 更新後序表達式
                suffix_expression.erase(suffix_expression.begin() + i, suffix_expression.begin() + i + 3);
                suffix_expression.insert(suffix_expression.begin() + i, to_string(res));

                // 輸出目前狀態
                for (auto& t : suffix_expression) cout << t << " ";
                cout << "\n";

                simplified = true;
                break;
                
            }
        }
        if (!simplified) break;
    }


    return 0;
}
