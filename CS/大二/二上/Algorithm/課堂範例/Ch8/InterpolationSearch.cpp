#include <bis/stdc++.h>
using namespace std;

// 標準內插搜尋 (Interpolation Search)
int interpolationSearch(const vector<int>& v, int key) {
    int low = 0;
    int high = v.size() - 1;

    while (low <= high && key >= v[low] && key <= v[high]) {
        if (low == high) {
            if (v[low] == key) return low;
            return -1;
        }

        // 使用比例 x 來預測落點位置
        double ratio = (double)(key - v[low]) / (v[high] - v[low]);
        int mid = low + (ratio * (high - low));

        if (v[mid] == key) return mid;

        if (v[mid] < key) low = mid + 1;
        else high = mid - 1;
            
    }
    return -1;
}

// 強健內插搜尋 (Robust Interpolation Search)
int robustInterpolationSearch(const vector<int>& v, int key) {
    int low = 0;
    int high = v.size() - 1;

    while (low <= high && key >= v[low] && key <= v[high]) {
        int n = high - low + 1;
        if (n <= 3) { // 當範圍很小時直接線性搜尋或判斷，避免 gap 計算問題
            for (int i = low; i <= high; i++) if (v[i] == key) return i;
            return -1;
        }

        // gap
        int gap = floor(sqrt(n)); 

        // 計算初步的 mid
        double ratio = (double)(key - v[low]) / (v[high] - v[low]);
        int mid = low + (ratio * (high - low));

        // 修正 mid，使其永遠落在 [low + gap, high - gap] 之間
        mid = min(max(low + gap, mid), high - gap);

        if (v[mid] == key) return mid;

        if (v[mid] < key) low = mid + 1;
        else high = mid - 1;
    }
    return -1;
}

int main() {
    vector<int> v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 100};
    int target = 7;

    cout << "target: " << target << endl;

    // 標準內插搜尋
    int res1 = interpolationSearch(v, target);
    cout << "InterpolationSearch : " << res1 << endl;

    // 強健內插搜尋
    int res2 = robustInterpolationSearch(v, target);
    cout << "RobustInterpolationSearch : " << res2 << endl;

    return 0;
}