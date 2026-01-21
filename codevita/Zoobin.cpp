#include <bits/stdc++.h>
using namespace std;

struct VectorHash {
    size_t operator()(const vector<pair<int, int>>& v) const {
        size_t seed = v.size();
        for (auto& i : v) {
            seed ^= hash<int>()(i.first) + 0x9e3779b9 + (seed << 6) + (seed >> 2);
            seed ^= hash<int>()(i.second) + 0x9e3779b9 + (seed << 6) + (seed >> 2);
        }
        return seed;
    }
};

void find_cycles(int start, const vector<vector<int>>& adj, int n, vector<vector<int>>& cycles) {
  vector<int> path;
  vector<bool> vis(n + 1, false);
  function<void(int)> dfs = [&](int u) {
    path.push_back(u);
    vis[u] = true;
    for (int v : adj[u]) {
      if (v == start && path.size() >= 3) {
        vector<int> cyc = path;
        cyc.push_back(start);
        cycles.push_back(cyc);
      } else if (!vis[v]) {
        dfs(v);
      }
    }
    path.pop_back();
    vis[u] = false;
  };
  dfs(start);
}

vector<vector<int>> get_all_oriented_cycles(const vector<vector<int>>& adj, int n) {
  vector<vector<int>> cycles;
  for (int start = 1; start <= n; ++start) {
    find_cycles(start, adj, n, cycles);
  }
  return cycles;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int E;
  cin >> E;
  vector<pair<int, int>> curr_edges(E);
  int n = 0;
  for (int i = 0; i < E; ++i) {
    int a, b;
    cin >> a >> b;
    if (a > b) swap(a, b);
    curr_edges[i] = {a, b};
    n = max(n, max(a, b));
  }
  vector<pair<int, int>> exp_edges(E);
  for (int i = 0; i < E; ++i) {
    int a, b;
    cin >> a >> b;
    if (a > b) swap(a, b);
    exp_edges[i] = {a, b};
    n = max(n, max(a, b));
  }
  vector<pair<int, int>> start_state = curr_edges;
  sort(start_state.begin(), start_state.end());
  vector<pair<int, int>> goal_state = exp_edges;
  sort(goal_state.begin(), goal_state.end());
  if (start_state == goal_state) {
    cout << 0 << "\n";
    return 0;
  }
  unordered_map<vector<pair<int, int>>, int, VectorHash> dist;
  queue<vector<pair<int, int>>> q;
  q.push(start_state);
  dist[start_state] = 0;
  bool found = false;
  int ans = -1;
  while (!q.empty() && !found) {
    auto cur = q.front();
    q.pop();
    int d = dist[cur];
    vector<vector<int>> adj(n + 1);
    for (auto& e : cur) {
      int u = e.first, v = e.second;
      adj[u].push_back(v);
      adj[v].push_back(u);
    }
    auto cycs = get_all_oriented_cycles(adj, n);
    for (auto& cyc : cycs) {
      int kk = cyc.size() - 1;
      if (kk < 3) continue;
      unordered_map<int, int> l2i;
      for (int i = 0; i < kk; ++i) {
        l2i[cyc[i]] = i;
      }
      vector<pair<int, int>> news;
      for (auto& e : cur) {
        int a = e.first, b = e.second;
        int pa = l2i.count(a) ? cyc[(l2i[a] + kk - 1) % kk] : a;
        int pb = l2i.count(b) ? cyc[(l2i[b] + kk - 1) % kk] : b;
        if (pa > pb) swap(pa, pb);
        news.emplace_back(pa, pb);
      }
      sort(news.begin(), news.end());
      if (news == goal_state) {
        ans = d + 1;
        found = true;
        break;
      }
      if (dist.find(news) == dist.end()) {
        dist[news] = d + 1;
        q.push(news);
      }
    }
    if (found) break;
  }
  cout << ans << "\n";
  return 0;
}