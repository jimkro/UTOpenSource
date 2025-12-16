#include<bits/stdc++.h>
using namespace std;
using ll = long long;
const int MAX_VAL = 500005; 

/**
 * Binary Indexed Tree (BIT / Fenwick Tree)
 */
struct BIT{
    vector<ll> tree;
    int size;

    BIT(int n){
        size = n;
        tree.resize(n + 1, 0); // 1-based indexing
    }

    // 在「值」= idx 上增加 val
    void add(int idx, ll val){
        if (idx < 0) return; // 避免 -1 
        idx++; 
        while (idx <= size){
            tree[idx] += val;
            idx += idx & (-idx); 
        }
    }

    // 查詢「值」在 [0, idx] 區間的總和
    ll query(int idx){
        idx++;
        ll sum = 0;
        while (idx > 0){
            sum += tree[idx];
            idx -= idx & (-idx); 
        }
        return sum;
    }
};

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int N, Q; cin >> N >> Q;
    
    vector<int> A(N + 1);

    BIT bit_count(MAX_VAL);
    BIT bit_sum(MAX_VAL);

    // 1. 初始化
    for (int i = 1; i <= N; ++i){
        cin >> A[i];
        bit_count.add(A[i], 1);    
        bit_sum.add(A[i], A[i]); 
    }

    // 2. 處理 Q 筆查詢
    while (Q--){
        int type; cin >> type;
        
        if (type == 1){ // 修改  
            int x, y; cin >> x >> y;
            
            int old_val = A[x];
            int new_val = y;

            bit_count.add(old_val, -1);
            bit_sum.add(old_val, -old_val);
            bit_count.add(new_val, 1);
            bit_sum.add(new_val, new_val);
            A[x] = new_val;

        }else{ // 查詢
            int l, r; cin >> l >> r;
            
            if (l > r){
                // 如果 l > r, 答案永遠是 N * l
                cout << (ll)N * l << "\n";
            }else{
                // 這是 l <= r 的「正常」情況
                // 查詢 = (count(A_i < l) * l) + (sum(l <= A_i <= r)) + (count(A_i > r) * r)

                // 第一段：A_i < l
                ll count_less_l = bit_count.query(l - 1);

                // 第三段：A_i > r
                // (注意：這裡的 N 是「常數」，不是 bit_count.query(MAX_VAL-1))
                // (因為 A[i] 可能會被修改成 0，所以總數 N 恆定)
                ll count_le_r = bit_count.query(r);
                ll count_greater_r = N - count_le_r;

                // 第二段：l <= A_i <= r
                ll sum_le_r = bit_sum.query(r);
                ll sum_less_l = bit_sum.query(l - 1);
                ll sum_between = sum_le_r - sum_less_l;

                ll ans = (count_less_l * l) + (sum_between) + (count_greater_r * r);
                cout << ans << "\n";
            }
        }
    }

    return 0;
}