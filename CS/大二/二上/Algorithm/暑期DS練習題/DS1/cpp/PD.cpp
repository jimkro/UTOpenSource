#include <bits/stdc++.h>

using namespace std;

string toBinary(int n) {
    string res = "";
    while (n > 0) {
        res = char('0' + (n % 2)) + res;
        n /= 2;
    }
    return res.empty() ? "0" : res;
}

string xor_binary(const string& a, const string& b) {
    int len = max(a.size(), b.size());
    string a_pad = string(len - a.size(), '0') + a;
    string b_pad = string(len - b.size(), '0') + b;
    string result = "";
    for (int i = 0; i < len; i++) {
        result += (a_pad[i] == b_pad[i]) ? '0' : '1';
    }
    return result;
}

string get_middle(const string& s) {
    if (s.length() < 8)
        return string(8 - s.length(), '0') + s;
    int mid = s.length() / 2;
    return s.substr(mid - 4, 8);
}

int bin_to_dec(const string& bin) {
    int res = 0;
    for (char c : bin) {
        res = res * 2 + (c - '0');
    }
    return res;
}

int h1(const string& A1, const string& A2) {
    string x = xor_binary(A1, A2);
    string mid = get_middle(x);
    return bin_to_dec(mid);
}

// 這裡改成用 B2
int h2(const string& B1, const string& B3, const string& B2) {
    string k1 = xor_binary(B1, B3);
    string x = xor_binary(k1, B2);
    string mid = get_middle(x);
    return bin_to_dec(mid);
}

int main() {
    int n;
    while (cin >> n) {
        string bin = toBinary(n);
        int t = bin.size();

        int lenA1 = (t + 1) / 2;
        int lenA2 = t / 2;
        string A1 = bin.substr(0, lenA1);
        string A2 = bin.substr(lenA1);

        int lenB = t / 3;
        string B1 = bin.substr(0, lenB);
        string B2 = bin.substr(lenB, lenB);
        string B3 = bin.substr(2 * lenB, lenB);

        int ans1 = h1(A1, A2);
        int ans2 = h2(B1, B3, B2);

        cout << ans1 << " " << ans2 << endl;
    }
    return 0;
}
