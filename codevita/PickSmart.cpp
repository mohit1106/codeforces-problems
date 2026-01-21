#include <bits/stdc++.h>
using namespace std;

struct Point {
    double x, y;
    Point(double x = 0, double y = 0) : x(x), y(y) {}
    Point operator-(const Point& p) const { return {x - p.x, y - p.y}; }
    Point operator+(const Point& p) const { return {x + p.x, y + p.y}; }
    Point operator*(double s) const { return {x * s, y * s}; }
    double cross(const Point& p) const { return x * p.y - y * p.x; }
};

bool eq(const Point& a, const Point& b) {
    return fabs(a.x - b.x) < 1e-9 && fabs(a.y - b.y) < 1e-9;
}

double dist(const Point& a, const Point& b) {
    return hypot(a.x - b.x, a.y - b.y);
}

bool on_segment(const Point& p, const Point& a, const Point& b) {
    Point ap = p - a, ab = b - a;
    if (fabs(ab.cross(ap)) > 1e-9) return false;
    double dot = ap.x * ab.x + ap.y * ab.y;
    double len2 = ab.x * ab.x + ab.y * ab.y;
    return dot >= -1e-9 && dot <= len2 + 1e-9;
}

pair<bool, Point> get_intersect(const Point& p1, const Point& p2, const Point& q1, const Point& q2) {
    double dx1 = p2.x - p1.x;
    double dy1 = p2.y - p1.y;
    double dx2 = q2.x - q1.x;
    double dy2 = q2.y - q1.y;
    double den = dx1 * dy2 - dy1 * dx2;
    if (fabs(den) < 1e-9) return {false, {}};
    double t = ((q1.x - p1.x) * dy2 - (q1.y - p1.y) * dx2) / den;
    double s = ((q1.x - p1.x) * dy1 - (q1.y - p1.y) * dx1) / den;
    if (t >= -1e-9 && t <= 1 + 1e-9 && s >= -1e-9 && s <= 1 + 1e-9) {
        double ix = p1.x + t * dx1;
        double iy = p1.y + t * dy1;
        return {true, {ix, iy}};
    }
    return {false, {}};
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    double pi = acos(-1.0);
    int N;
    cin >> N;
    vector<pair<Point, Point>> sticks(N);
    double total_len = 0;
    for (int i = 0; i < N; i++) {
        double x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        sticks[i] = {{x1, y1}, {x2, y2}};
        total_len += dist(sticks[i].first, sticks[i].second);
    }
    vector<Point> points;
    auto add_point = [&](Point p) -> int {
        for (int j = 0; j < (int)points.size(); j++) {
            if (eq(points[j], p)) return j;
        }
        points.push_back(p);
        return (int)points.size() - 1;
    };
    for (auto& s : sticks) {
        add_point(s.first);
        add_point(s.second);
    }
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
            auto [has, inter] = get_intersect(sticks[i].first, sticks[i].second, sticks[j].first, sticks[j].second);
            if (has) {
                add_point(inter);
            }
        }
    }
    int npts = (int)points.size();
    vector<vector<int>> adj(npts);
    for (int i = 0; i < N; i++) {
        Point a = sticks[i].first, b = sticks[i].second;
        double dx = b.x - a.x, dy = b.y - a.y;
        vector<pair<double, int>> proj;
        for (int j = 0; j < npts; j++) {
            if (on_segment(points[j], a, b)) {
                double t = (fabs(dx) > fabs(dy) ? (points[j].x - a.x) / dx : (points[j].y - a.y) / dy);
                proj.emplace_back(t, j);
            }
        }
        sort(proj.begin(), proj.end());
        for (size_t k = 0; k + 1 < proj.size(); k++) {
            int u = proj[k].second;
            int v = proj[k + 1].second;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
    }
    vector<int> parent(npts, -1);
    vector<bool> visited(npts, false);
    int cycle_start = -1, cycle_end = -1;
    bool has_cycle = false;
    function<void(int)> dfs = [&](int u) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (v == parent[u]) continue;
            if (visited[v]) {
                if (!has_cycle) {
                    cycle_end = u;
                    cycle_start = v;
                    has_cycle = true;
                }
                continue;
            }
            parent[v] = u;
            dfs(v);
        }
    };
    for (int i = 0; i < npts; i++) {
        if (!visited[i]) {
            parent[i] = -1;
            dfs(i);
            if (has_cycle) break;
        }
    }
    if (!has_cycle) {
        cout << "Abandoned" << endl;
        return 0;
    }
    vector<int> cycle;
    int cur = cycle_end;
    while (cur != cycle_start) {
        cycle.push_back(cur);
        cur = parent[cur];
    }
    cycle.push_back(cycle_start);
    reverse(cycle.begin(), cycle.end());
    auto shoelace = [&](const vector<int>& cyc) -> double {
        int m = (int)cyc.size();
        double area = 0;
        for (int i = 0; i < m; i++) {
            Point p1 = points[cyc[i]];
            Point p2 = points[cyc[(i + 1) % m]];
            area += p1.x * p2.y - p1.y * p2.x;
        }
        return fabs(area) / 2.0;
    };
    double kal_area = shoelace(cycle);
    double used_len = 0;
    int m = (int)cycle.size();
    for (int i = 0; i < m; i++) {
        Point p1 = points[cycle[i]];
        Point p2 = points[cycle[(i + 1) % m]];
        used_len += dist(p1, p2);
    }
    double L = total_len - used_len;
    double comp_area = (L * L) / (4 * pi);
    if (kal_area > comp_area) {
        cout << "Kalyan" << endl;
    } else {
        cout << "Computer" << endl;
    }
    return 0;
}