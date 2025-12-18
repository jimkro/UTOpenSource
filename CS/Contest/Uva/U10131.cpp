// name : Is Bigger Smarter?
#include <bits/stdc++.h>
using namespace std;

struct Elephant{
    int id = 0, weight = 0, IQ = 0;
    Elephant(){}
    Elephant(int id, int weight, int IQ) : id(id), weight(weight), IQ(IQ){};
};


int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    auto cmp = [&](const Elephant& e1, const Elephant& e2){
        return e1.weight < e2.weight && e1.IQ > e2.IQ;
    };
    
    vector<Elephant> all;
    Elephant elephant;
    int num = 1;
    while(cin >> elephant.weight >> elephant.IQ){
        elephant.id = num++;
        all.push_back(elephant);
    }

    vector<Elephant> tail;
    for(auto& e : all){
        auto it = lower_bound(tail.begin(), tail.end(), e, cmp);
        if(it == tail.end()) tail.push_back(e);
        else *it = e;
    }
    
    // vector<int> res;
    // res.push_back(v[0].id);
    // for(int i = 1; i < v.size();){
    //     if(v[i].weight == v[i-1].weight || v[i].IQ == v[i-1].IQ){
    //         v.erase(v.begin() + i);
    //     }else{
    //         i++;
    //     }
    // }
    cout << tail.size() << "\n";
    for(auto& e : tail){
        cout << e.id << "\n";
    }
}