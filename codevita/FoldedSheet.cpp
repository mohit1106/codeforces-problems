#include <bits/stdc++.h>
using namespace std;

int main() {
    int R, C;
    cin >> R >> C;
    string dummy;
    getline(cin, dummy); // consume newline
    string line;
    getline(cin, line);
    stringstream ss(line);
    vector<pair<char, int>> folds;
    string tok;
    while (ss >> tok) {
        char t = tok[0];
        int num = stoi(tok.substr(1));
        folds.emplace_back(t, num);
    }
    int cur_R = R, cur_C = C;
    vector<vector<vector<int>>> g(cur_R + 1, vector<vector<int>>(cur_C + 1));
    for (int i = 1; i <= cur_R; i++) {
        for (int j = 1; j <= cur_C; j++) {
            g[i][j] = {(i - 1) * C + j};
        }
    }
    for (auto& f : folds) {
        char typ = f.first;
        int id = f.second;
        if (typ == 'v') {
            int m = id;
            int rw = cur_C - m;
            int mt = m + 1 - rw;
            int sh = max(0, 1 - mt);
            int nc = m + sh;
            vector<vector<vector<int>>> ng(cur_R + 1, vector<vector<int>>(nc + 1));
            // left
            for (int jj = 1; jj <= m; jj++) {
                int nj = jj + sh;
                for (int ii = 1; ii <= cur_R; ii++) {
                    ng[ii][nj] = g[ii][jj];
                }
            }
            // right folded
            for (int jj = m + 1; jj <= cur_C; jj++) {
                int d = jj - m;
                int tar = m + 1 - d;
                int nj = tar + sh;
                for (int ii = 1; ii <= cur_R; ii++) {
                    vector<int> stk = g[ii][jj];
                    reverse(stk.begin(), stk.end());
                    for (int val : stk) {
                        ng[ii][nj].push_back(val);
                    }
                }
            }
            g = move(ng);
            cur_C = nc;
        } else { // h
            int k = id;
            int bh = cur_R - k;
            int mt = k + 1 - bh;
            int sh = max(0, 1 - mt);
            int nr = k + sh;
            vector<vector<vector<int>>> ng(nr + 1, vector<vector<int>>(cur_C + 1));
            // top
            for (int ii = 1; ii <= k; ii++) {
                int ni = ii + sh;
                for (int jj = 1; jj <= cur_C; jj++) {
                    ng[ni][jj] = g[ii][jj];
                }
            }
            // bottom folded
            for (int ii = k + 1; ii <= cur_R; ii++) {
                int d = ii - k;
                int tar = k + 1 - d;
                int ni = tar + sh;
                for (int jj = 1; jj <= cur_C; jj++) {
                    vector<int> stk = g[ii][jj];
                    reverse(stk.begin(), stk.end());
                    for (int val : stk) {
                        ng[ni][jj].push_back(val);
                    }
                }
            }
            g = move(ng);
            cur_R = nr;
        }
    }
    int top_cell = g[1][1].back();
    int bot_cell = g[1][1].front();
    cout << top_cell << " " << bot_cell << endl;
    return 0;
}