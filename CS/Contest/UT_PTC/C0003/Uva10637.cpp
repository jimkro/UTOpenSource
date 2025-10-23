#include<bits/stdc++.h>
using namespace std;

int S_target; // 目標總和 S
int t_parts;  // 要分割成的數量 t
vector<vector<int>> all_solutions;
vector<int> current_solution;

int gcd(int a, int b) {
    return b == 0 ? a : gcd(b,a%b);
}

void find_partitions(int now_sum, int parts_left, int start_num) {
    // 剪枝 : 如果剩下的數字都選最小的 start_num，總和會超過 S，則可以提前中止
    if (now_sum + parts_left * start_num > S_target) return;

    // Base Case
    if (parts_left == 1) {
        int last_num = S_target - now_sum;

        // 確認最後一個數字不小於前一個數字，維持順序
        if (last_num < start_num) {
            return;
        }

        // 檢查最後一個數字是否和前面所有數字都互質
        for (int num : current_solution) {
            if (gcd(num, last_num) != 1) {
                return; // 不互質，這不是一組有效的解
            }
        }
        
        // 找到了一組解
        current_solution.push_back(last_num);
        all_solutions.push_back(current_solution);
        current_solution.pop_back(); // 回溯
        return;
    }

    // 遞迴本體：遍歷當前數字 i 的所有可能性
    // i 的上限：(S - 目前的和) / 剩下數量
    int upper_bound = (S_target - now_sum) / parts_left;
    for (int i = start_num; i <= upper_bound; ++i) {
        // 檢查 i 是否和已經選擇的數字都互質
        bool is_coprime = true;
        for (int num : current_solution) {
            if (gcd(num, i) != 1) {
                is_coprime = false;
                break;
            }
        }

        if (is_coprime) {
            current_solution.push_back(i);
            // 遞迴尋找下一個數字，下一個數字的起始點是 i
            find_partitions(now_sum + i, parts_left - 1, i);
            current_solution.pop_back(); // 回溯 (退回上一步，嘗試其他可能)
        }
    }
}

void solve() {
    cin >> S_target >> t_parts;

    // 清空上一組測試資料的結果
    all_solutions.clear();
    current_solution.clear();

    // 遞迴解
    find_partitions(0, t_parts, 1);
    
    // 輸出所有解
    for (const auto& solution : all_solutions) {
        for (int i = 0; i < solution.size(); ++i) {
            cout << solution[i] << (i != solution.size() - 1 ? " " : "");
        }
        cout << "\n";
    }
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);

    int N; cin >> N;

    for (int case_num = 1; case_num <= N; ++case_num) {
        cout << "Case " << case_num << ":\n";
        solve();
    }

    return 0;
}