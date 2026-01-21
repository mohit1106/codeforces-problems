#include <bits/stdc++.h>
using namespace std;

struct State {
    int o, sr, sc;
};

bool is_valid(int o, int sr, int sc, int len, const vector<vector<char>>& grid, int M, int N) {
    if (o == 0) { // Horizontal
        if (sr < 0 || sr >= M || sc < 0 || sc + len - 1 >= N) return false;
        for (int i = 0; i < len; i++) {
            if (grid[sr][sc + i] == 'B') return false;
        }
    } else { // Vertical
        if (sr < 0 || sr + len - 1 >= M || sc < 0 || sc >= N) return false;
        for (int i = 0; i < len; i++) {
            if (grid[sr + i][sc] == 'B') return false;
        }
    }
    return true;
}

bool square_empty(int r1, int c1, int r2, int c2, const vector<vector<char>>& grid, int M, int N) {
    if (r1 < 0 || r2 >= M || c1 < 0 || c2 >= N || r1 > r2 || c1 > c2) return false;
    for (int i = r1; i <= r2; ++i) {
        for (int j = c1; j <= c2; ++j) {
            if (grid[i][j] == 'B') return false;
        }
    }
    return true;
}

int main() {
    int M, N;
    cin >> M >> N;
    vector<vector<char>> grid(M, vector<char>(N));
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            cin >> grid[i][j];
        }
    }
    vector<pair<int, int>> sources, targets;
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            if (grid[i][j] == 'l') sources.emplace_back(i, j);
            else if (grid[i][j] == 'L') targets.emplace_back(i, j);
        }
    }
    int len = sources.size();
    // Initial position
    set<int> srows, scols;
    for (auto [x, y] : sources) {
        srows.insert(x);
        scols.insert(y);
    }
    int init_o = -1, init_sr = -1, init_sc = -1;
    if (srows.size() == 1 && scols.size() == (size_t)len) {
        init_o = 0;
        init_sr = *srows.begin();
        init_sc = *scols.begin();
    } else if (scols.size() == 1 && srows.size() == (size_t)len) {
        init_o = 1;
        init_sr = *srows.begin();
        init_sc = *scols.begin();
    }
    // Target position
    set<int> trows, tcols;
    for (auto [x, y] : targets) {
        trows.insert(x);
        tcols.insert(y);
    }
    int target_o = -1, target_sr = -1, target_sc = -1;
    if (trows.size() == 1 && tcols.size() == (size_t)len) {
        target_o = 0;
        target_sr = *trows.begin();
        target_sc = *tcols.begin();
    } else if (tcols.size() == 1 && trows.size() == (size_t)len) {
        target_o = 1;
        target_sr = *trows.begin();
        target_sc = *tcols.begin();
    }
    if (init_o == -1 || target_o == -1) {
        cout << "Impossible" << endl;
        return 0;
    }
    // BFS
    vector<vector<vector<int>>> dist(2, vector<vector<int>>(M, vector<int>(N, -1)));
    queue<State> q;
    dist[init_o][init_sr][init_sc] = 0;
    q.push({init_o, init_sr, init_sc});
    int ans = -1;
    int dirs[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    while (!q.empty()) {
        State cur = q.front();
        q.pop();
        int cd = dist[cur.o][cur.sr][cur.sc];
        if (cur.o == target_o && cur.sr == target_sr && cur.sc == target_sc) {
            ans = cd;
            break;
        }
        // Translations
        for (int k = 0; k < 4; k++) {
            int ddr = dirs[k][0];
            int ddc = dirs[k][1];
            int nsr = cur.sr + ddr;
            int nsc = cur.sc + ddc;
            if (is_valid(cur.o, nsr, nsc, len, grid, M, N)) {
                if (dist[cur.o][nsr][nsc] == -1) {
                    dist[cur.o][nsr][nsc] = cd + 1;
                    q.push({cur.o, nsr, nsc});
                }
            }
        }
        // Rotations
        if (cur.o == 0) { // H to V
            // Down
            {
                int r1 = cur.sr;
                int r2 = cur.sr + len - 1;
                int c1 = cur.sc;
                int c2 = cur.sc + len - 1;
                if (r2 < M && square_empty(r1, c1, r2, c2, grid, M, N)) {
                    int no = 1;
                    int nsr = cur.sr;
                    // Left pivot
                    int nsc = cur.sc;
                    if (dist[no][nsr][nsc] == -1) {
                        dist[no][nsr][nsc] = cd + 1;
                        q.push({no, nsr, nsc});
                    }
                    // Right pivot
                    nsc = cur.sc + len - 1;
                    if (dist[no][nsr][nsc] == -1) {
                        dist[no][nsr][nsc] = cd + 1;
                        q.push({no, nsr, nsc});
                    }
                }
            }
            // Up
            {
                int r1 = cur.sr - len + 1;
                int r2 = cur.sr;
                int c1 = cur.sc;
                int c2 = cur.sc + len - 1;
                if (r1 >= 0 && square_empty(r1, c1, r2, c2, grid, M, N)) {
                    int no = 1;
                    int nsr = r1;
                    // Left pivot
                    int nsc = cur.sc;
                    if (dist[no][nsr][nsc] == -1) {
                        dist[no][nsr][nsc] = cd + 1;
                        q.push({no, nsr, nsc});
                    }
                    // Right pivot
                    nsc = cur.sc + len - 1;
                    if (dist[no][nsr][nsc] == -1) {
                        dist[no][nsr][nsc] = cd + 1;
                        q.push({no, nsr, nsc});
                    }
                }
            }
        } else { // V to H
            // Right
            {
                int c1 = cur.sc;
                int c2 = cur.sc + len - 1;
                int r1 = cur.sr;
                int r2 = cur.sr + len - 1;
                if (c2 < N && square_empty(r1, c1, r2, c2, grid, M, N)) {
                    int no = 0;
                    int nsc = cur.sc;
                    // Top pivot
                    int nsr = cur.sr;
                    if (dist[no][nsr][nsc] == -1) {
                        dist[no][nsr][nsc] = cd + 1;
                        q.push({no, nsr, nsc});
                    }
                    // Bottom pivot
                    nsr = cur.sr + len - 1;
                    if (dist[no][nsr][nsc] == -1) {
                        dist[no][nsr][nsc] = cd + 1;
                        q.push({no, nsr, nsc});
                    }
                }
            }
            // Left
            {
                int c1 = cur.sc - len + 1;
                int c2 = cur.sc;
                int r1 = cur.sr;
                int r2 = cur.sr + len - 1;
                if (c1 >= 0 && square_empty(r1, c1, r2, c2, grid, M, N)) {
                    int no = 0;
                    int nsc = c1;
                    // Top pivot
                    int nsr = cur.sr;
                    if (dist[no][nsr][nsc] == -1) {
                        dist[no][nsr][nsc] = cd + 1;
                        q.push({no, nsr, nsc});
                    }
                    // Bottom pivot
                    nsr = cur.sr + len - 1;
                    if (dist[no][nsr][nsc] == -1) {
                        dist[no][nsr][nsc] = cd + 1;
                        q.push({no, nsr, nsc});
                    }
                }
            }
        }
    }
    if (ans != -1) {
        cout << ans << endl;
    } else {
        cout << "Impossible" << endl;
    }
    return 0;
}