#include <bits/stdc++.h>

using namespace std;

struct Mosquito {
    int no = 0;
    double weight = 0.0;
    double speed = 0.0;
    int decibel = 0;
};

int main() {
    ios::sync_with_stdio(false); cin.tie(nullptr);cout.tie(nullptr);
    
    int n;
    while(cin >> n){
        if(n == 0) break;

        vector<Mosquito> mosquitos(n);
        for (int i = 0; i < n; i++) {
            cin >> mosquitos[i].no >> mosquitos[i].weight >> mosquitos[i].speed >> mosquitos[i].decibel;
        }

        sort(mosquitos.begin(), mosquitos.end(), [](const Mosquito& a, const Mosquito& b) {
            if (a.decibel != b.decibel) return a.decibel > b.decibel;
            if (a.speed != b.speed) return a.speed > b.speed;
            if (a.weight != b.weight) return a.weight < b.weight;
            return a.no < b.no;
        });

        for (const auto& mosquito : mosquitos) {
            cout << mosquito.no << " ";
        }
        cout << '\n';
    }
    
}
