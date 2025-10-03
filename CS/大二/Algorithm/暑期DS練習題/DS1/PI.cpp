#include <bits/stdc++.h>

using namespace std;

void printQ(queue<int> q){
    if(q.empty()) return;
    while(!q.empty()){
        cout << q.front() << " ";
        q.pop();
    }
    cout << "\n";
}

int main() {
    ios::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);

    while(1){
        size_t limit;
        cin >> limit;
        if(limit == 0) break;

        cin.ignore();
        
        string line;
        getline(cin, line);
        stringstream ss(line);

        queue<int> inputQ;
        queue<int> processQ;

        int num;
        while(ss >> num) {
            inputQ.push(num);
        }

        while(!inputQ.empty()){
            while(processQ.size() < limit && !inputQ.empty()){
                processQ.push(inputQ.front());
                inputQ.pop();
            }
            // printQ(processQ);
            if(empty(inputQ)) break;

            if(inputQ.front() > processQ.front()){  // input -> process
                processQ.push(inputQ.front());
                inputQ.pop();

                inputQ.push(processQ.front());
                processQ.pop();
            }else{ // 重排 
                inputQ.push(inputQ.front());
                inputQ.pop();
                
                processQ.push(processQ.front());
                processQ.pop();
            }
            // printQ(processQ);
            limit++;
        }

        printQ(processQ);
    }
    return 0;
}
