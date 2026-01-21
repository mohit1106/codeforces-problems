#include <bits/stdc++.h>

using namespace std;

vector<string> split_row(const string& line) {
    vector<string> parts;
    size_t pos = 0;
    while (pos < line.size()) {
        if (pos + 2 >= line.size()) break;
        string pat = line.substr(pos, 3);
        parts.push_back(pat);
        pos += 3;
        while (pos < line.size() && isspace(static_cast<unsigned char>(line[pos]))) {
            ++pos;
        }
    }
    return parts;
}

string get_pattern_bin(const string& r0, const string& r1, const string& r2) {
    string bin = "";
    for (const string& row : {r0, r1, r2}) {
        for (char ch : row) {
            bin += (ch == '|' || ch == '_') ? '1' : '0';
        }
    }
    return bin;
}

string pad_left(string s, size_t l) {
    if (s.size() >= l) return s;
    string z(l - s.size(), '0');
    return z + s;
}

string my_bit_or(const string& a, const string& b) {
    size_t ml = max(a.size(), b.size());
    string la = pad_left(a, ml);
    string lb = pad_left(b, ml);
    string res(ml, '0');
    for (size_t i = 0; i < ml; i++) {
        res[i] = '0' + ((la[i] - '0') | (lb[i] - '0'));
    }
    return res;
}

string my_bit_and(const string& a, const string& b) {
    size_t ml = max(a.size(), b.size());
    string la = pad_left(a, ml);
    string lb = pad_left(b, ml);
    string res(ml, '0');
    for (size_t i = 0; i < ml; i++) {
        res[i] = '0' + ((la[i] - '0') & (lb[i] - '0'));
    }
    return res;
}

string my_bit_not(const string& a) {
    string res(a.size(), '0');
    for (size_t i = 0; i < a.size(); i++) {
        res[i] = '0' + (1 - (a[i] - '0'));
    }
    return res;
}

string get_bin(const string& num, const array<string, 10>& digit_bin) {
    string b;
    for (char ch : num) {
        int d = ch - '0';
        b += digit_bin[d];
    }
    return b;
}

string multiply_by_two(string num) {
    if (num.empty() || num == "0") return "0";
    string res;
    int carry = 0;
    for (int i = num.size() - 1; i >= 0; --i) {
        int d = num[i] - '0';
        int temp = d * 2 + carry;
        res = char(temp % 10 + '0') + res;
        carry = temp / 10;
    }
    if (carry) res = char(carry + '0') + res;
    return res;
}

string add_one(string num) {
    if (num == "0") return "1";
    string n = num; // copy
    int i = n.size() - 1;
    int carry = 1;
    while (i >= 0 && carry) {
        int d = (n[i] - '0') + carry;
        n[i] = (d % 10) + '0';
        carry = d / 10;
        --i;
    }
    if (carry) n = '1' + n;
    return n;
}

string binary_to_decimal(string bin) {
    string result = "0";
    for (char c : bin) {
        result = multiply_by_two(result);
        if (c == '1') {
            result = add_one(result);
        }
    }
    return result;
}

string parse_atom(const vector<string>& tokens, int& pos, const array<string, 10>& digit_bin);

string parse_or_expr(const vector<string>& tokens, int& pos, const array<string, 10>& digit_bin) {
    string val = parse_atom(tokens, pos, digit_bin);
    while (pos < (int)tokens.size() && tokens[pos] == "|") {
        ++pos;
        string right = parse_atom(tokens, pos, digit_bin);
        val = my_bit_or(val, right);
    }
    return val;
}

string parse_and_expr(const vector<string>& tokens, int& pos, const array<string, 10>& digit_bin) {
    string val = parse_or_expr(tokens, pos, digit_bin);
    while (pos < (int)tokens.size() && tokens[pos] == "&") {
        ++pos;
        string right = parse_or_expr(tokens, pos, digit_bin);
        val = my_bit_and(val, right);
    }
    return val;
}

string parse_expression(const vector<string>& tokens, int& pos, const array<string, 10>& digit_bin) {
    return parse_and_expr(tokens, pos, digit_bin);
}

string parse_atom(const vector<string>& tokens, int& pos, const array<string, 10>& digit_bin) {
    if (pos >= (int)tokens.size()) {
        return "";
    }
    const string& t = tokens[pos];
    if (isdigit(t[0])) {
        string num = t;
        ++pos;
        return get_bin(num, digit_bin);
    } else if (t == "(") {
        ++pos;
        string val = parse_expression(tokens, pos, digit_bin);
        if (pos < (int)tokens.size() && tokens[pos] == ")") {
            ++pos;
        }
        return val;
    } else if (t == "~") {
        ++pos;
        return my_bit_not(parse_atom(tokens, pos, digit_bin));
    } else {
        return "";
    }
}

int main() {
    string dline0, dline1, dline2;
    getline(cin, dline0);
    getline(cin, dline1);
    getline(cin, dline2);
    vector<string> d0_parts = split_row(dline0);
    vector<string> d1_parts = split_row(dline1);
    vector<string> d2_parts = split_row(dline2);
    if (d0_parts.size() != 10 || d1_parts.size() != 10 || d2_parts.size() != 10) {
        cout << "0" << endl;
        return 0;
    }
    array<string, 10> digit_bin;
    map<string, char> sym_to_char;
    for (int i = 0; i < 10; i++) {
        string r0 = d0_parts[i];
        string r1 = d1_parts[i];
        string r2 = d2_parts[i];
        string bin = get_pattern_bin(r0, r1, r2);
        sym_to_char[bin] = '0' + i;
        digit_bin[i] = bin;
    }
    string oline0, oline1, oline2;
    getline(cin, oline0);
    getline(cin, oline1);
    getline(cin, oline2);
    vector<string> o0_parts = split_row(oline0);
    vector<string> o1_parts = split_row(oline1);
    vector<string> o2_parts = split_row(oline2);
    if (o0_parts.size() != 5 || o1_parts.size() != 5 || o2_parts.size() != 5) {
        cout << "0" << endl;
        return 0;
    }
    char op_chars[5] = {'|', '&', '~', '(', ')'};
    for (int i = 0; i < 5; i++) {
        string r0 = o0_parts[i];
        string r1 = o1_parts[i];
        string r2 = o2_parts[i];
        string bin = get_pattern_bin(r0, r1, r2);
        sym_to_char[bin] = op_chars[i];
    }
    string eline0, eline1, eline2;
    getline(cin, eline0);
    getline(cin, eline1);
    getline(cin, eline2);
    vector<string> e0_parts = split_row(eline0);
    vector<string> e1_parts = split_row(eline1);
    vector<string> e2_parts = split_row(eline2);
    if (e0_parts.size() != e1_parts.size() || e0_parts.size() != e2_parts.size()) {
        cout << "0" << endl;
        return 0;
    }
    int M = e0_parts.size();
    vector<string> expr_bins(M);
    for (int j = 0; j < M; j++) {
        string r0 = e0_parts[j];
        string r1 = e1_parts[j];
        string r2 = e2_parts[j];
        expr_bins[j] = get_pattern_bin(r0, r1, r2);
    }
    vector<string> tokens;
    int i = 0;
    while (i < M) {
        string bin = expr_bins[i];
        auto it = sym_to_char.find(bin);
        if (it == sym_to_char.end()) {
            cout << "0" << endl;
            return 0;
        }
        char c = it->second;
        if (isdigit(c)) {
            string num = "";
            int start_i = i;
            while (i < M) {
                string cbin = expr_bins[i];
                auto cit = sym_to_char.find(cbin);
                if (cit == sym_to_char.end() || !isdigit(cit->second)) break;
                num += cit->second;
                ++i;
            }
            if (i == start_i) {
                // no digit
                cout << "0" << endl;
                return 0;
            }
            tokens.push_back(num);
        } else {
            tokens.push_back(string(1, c));
            ++i;
        }
    }
    int pos = 0;
    string res_bin = parse_expression(tokens, pos, digit_bin);
    if (pos != (int)tokens.size()) {
        cout << "0" << endl;
        return 0;
    }
    string res_dec = binary_to_decimal(res_bin);
    cout << res_dec << endl;
    return 0;
}