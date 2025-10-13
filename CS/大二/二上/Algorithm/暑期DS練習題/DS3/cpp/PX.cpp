#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
    

    string date;
    int num;
    while (cin >> date >> num) {
        int curr = stoi(date.substr(0, date.find('/')));
        cin.ignore();

        vector<int> students(num+1,0);

        string line;
        getline(cin,line);
        stringstream ss(line);
        int x;
        while(ss >> x) students[x] = -1;
        
        int cnt = 0;
        int ans = 0;

        while(cnt < 8){
            int ori = curr;
            int last = curr;

            do{
                if(students[curr] == 0){
                    students[curr] = 1;
                    cnt++;
                    // last = curr;
                    cout << curr << " ";
                }else if(students[curr] == -1) ans++;
                last = curr;
                curr += 10;
                if(curr > num) curr %= 10;
                if(curr == 0) curr = 10;
                
            }while(curr != ori && cnt < 8);

            curr = last + 1;
            if(curr > num) curr %= 10;
            if(curr == 0) curr = 10;
        }
        cout << "\nJimmy's angry number is " << ans << "\n";
    }

    return 0;
}
