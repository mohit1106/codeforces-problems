import java.io.*;
import java.util.*;

public class A_Copil_Copac_Draws_Trees {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
    @SuppressWarnings("unchecked")
    ArrayList<int[]>[] g = new ArrayList[n + 1];
    for (int i = 1; i <= n; ++i) g[i] = new ArrayList<>();

    for (int i = 1; i <= n - 1; ++i) {
        int u = in.nextInt();
        int v = in.nextInt();
        g[u].add(new int[]{v, i});
        g[v].add(new int[]{u, i});
    }

    int[] d = new int[n + 1];
    boolean[] vis = new boolean[n + 1];

    Deque<int[]> stack = new ArrayDeque<>();
    stack.push(new int[]{1, n}); 
    vis[1] = true;
    d[1] = 0;

    int max = 0;
    while (!stack.isEmpty()) {
        int[] cur = stack.pop();
        int node = cur[0], t = cur[1];
        for (int[] e : g[node]) {
            int nei = e[0], idx = e[1];
            if (!vis[nei]) {
                vis[nei] = true;
                d[nei] = d[node] + (idx < t ? 1 : 0);
                max = Math.max(max, d[nei]);
                stack.push(new int[]{nei, idx});
            }
        }
    }

    System.out.println(max);
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}