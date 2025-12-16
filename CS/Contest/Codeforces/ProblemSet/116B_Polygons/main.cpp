// Convex Hull
#include <bits/stdc++.h>
#define int long long
using namespace std;

struct Point {
    int x, y;
    bool operator<(const Point& other) const {
        if (x != other.x) return x < other.x;
        return y < other.y;
    }
};

int cross(const Point& p1, const Point& p2, const Point& p3) {
    return (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
}

signed main() {
    ios::sync_with_stdio(0); cin.tie(0);
    
    int n; cin >> n;
    vector<Point> ptsA(n);
    for (int i = 0; i < n; i++) cin >> ptsA[i].x >> ptsA[i].y;

    int m; cin >> m;
    vector<Point> ptsB(m);
    set<Point> stB; // 用來快速判斷該點是否來自 B
    for (int i = 0; i < m; i++) {
        cin >> ptsB[i].x >> ptsB[i].y;
        stB.insert(ptsB[i]);
    }

    // 合併點集
    vector<Point> all_pts = ptsA;
    for (auto p : ptsB) all_pts.push_back(p);

    sort(all_pts.begin(), all_pts.end());

    // 計算凸包 (Monotone Chain)
    vector<Point> hull;
    int tot = all_pts.size();

    // 下凸包：保留共線點，使用 < 0 而非 <= 0
    for (int i = 0; i < tot; i++) {
        while (hull.size() >= 2 && cross(hull[hull.size() - 2], hull.back(), all_pts[i]) < 0) {
            hull.pop_back();
        }
        hull.push_back(all_pts[i]);
    }

    // 上凸包
    int lower_size = hull.size();
    for (int i = tot - 2; i >= 0; i--) {
        while (hull.size() > lower_size && cross(hull[hull.size() - 2], hull.back(), all_pts[i]) < 0) {
            hull.pop_back();
        }
        hull.push_back(all_pts[i]);
    }
    if (tot > 1) hull.pop_back();

    // 檢查凸包上的點
    for (const auto& p : hull) {
        if (stB.count(p)) {
            cout << "NO\n";
            return 0;
        }
    }

    cout << "YES\n";
    return 0;
}