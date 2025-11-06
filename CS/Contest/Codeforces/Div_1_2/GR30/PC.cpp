#include <bits/stdc++.h>
using namespace std;
using ll = long long;

struct Monster {
    int life;
    int reward;
    bool operator<(const Monster& other) const {
        return this->life < other.life;
    }
};

void solve() {
    int n, m; cin >> n >> m;

    multiset<int> swords;
    for (int i = 0; i < n; i++) {
        int a; cin >> a;
        swords.insert(a);
    }

    vector<Monster> reward_monsters;
    vector<Monster> cost_monsters;
    
    vector<int> b(m), c(m);
    for (int i = 0; i < m; i++) cin >> b[i];
    for (int i = 0; i < m; i++) cin >> c[i];

    for (int i = 0; i < m; i++) {
        if (c[i] > 0) reward_monsters.push_back({b[i], c[i]});
        else cost_monsters.push_back({b[i], 0});
    }

    sort(reward_monsters.begin(), reward_monsters.end());
    sort(cost_monsters.begin(), cost_monsters.end());

    int kills = 0;

    for (const auto& monster : reward_monsters) {
        auto it = swords.lower_bound(monster.life);
        if (it == swords.end()) break;
        
        int sword_used = *it;
        swords.erase(it);
        swords.insert(max(sword_used, monster.reward));
        kills++;
    }
    
    for (const auto& monster : cost_monsters) {
        auto it = swords.lower_bound(monster.life);
        if (it == swords.end()) break;
        
        swords.erase(it);
        kills++;
    }

    cout << kills << "\n";
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    int T; cin >> T;
    while (T--) solve();
}