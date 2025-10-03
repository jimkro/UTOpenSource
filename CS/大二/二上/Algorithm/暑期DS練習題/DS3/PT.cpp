#include <bits/stdc++.h>

using namespace std;

void insert(vector<int>& ori,int r){
    int i = 0;
    int curr = ori[r];
    for(;i<r && ori[i] > curr;i++);
    ori.erase(ori.begin()+r);
    ori.insert(ori.begin() + i,curr);
}

void print_vector(const vector<int>& v){
    for(int e : v){
        cout << e << " ";
    }
    cout << "\n";
}

void insertion_sort(vector<int> ori,const int n){
    cout << "1\n";
    for(int i=0;i<n;i++){
        insert(ori,i);
        print_vector(ori);
    }
}

void bubble_sort(vector<int> ori,const int n){
    cout << "2\n";
    int len = ori.size();
    for(int i=0;i<n;i++){
        for(int j=len-1;j>=i+1;j--){
            if(ori[j] > ori[j-1]) swap(ori[j],ori[j-1]);
        }
        print_vector(ori);
    }
}

void selection_sort(vector<int> ori,const int n){
    cout << "3 \n";
    int len = ori.size();
    for(int i=0;i<n;i++){
        int maxIndex = i;
        for(int j=i;j<len;j++){
            if(ori[maxIndex] < ori[j]) maxIndex = j;
        }
        swap(ori[maxIndex],ori[i]);
        print_vector(ori);
    }
}

int main() {
    ios::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
    
    int m,n;
    while(cin >> m >> n){
        vector<int> ori(m);
        for(int i=0;i<m;i++) cin >> ori[i];
        insertion_sort(ori,n);
        bubble_sort(ori,n);
        selection_sort(ori,n);
    }
}
