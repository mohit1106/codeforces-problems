import java.io.*;
import java.util.*;

public class B_Merging_the_Sets {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer>[] sets = new ArrayList[n];
        ArrayList<Integer>[] providers = new ArrayList[m + 1];
        for (int i=1; i<= m; ++i) providers[i] = new ArrayList<>();
        for (int i=0; i<n; ++i) {
            int sz=in.nextInt();
            sets[i]=new ArrayList<>(sz);
            for (int j=0; j<sz; ++j) {
                int x = in.nextInt();
                sets[i].add(x);
                providers[x].add(i);
            }
        }
        int[] cnt = new int[m + 1];
        boolean[] covered = new boolean[m + 1];
        boolean[] forcedSet = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        boolean impossible = false;
        for (int x = 1; x <= m; ++x) {
            cnt[x] = providers[x].size();
            if (cnt[x] == 0) { impossible = true; break; }
            if (cnt[x] == 1) q.add(x);
        }
        if (impossible) { out.println("NO"); return; }
        while (!q.isEmpty()) {
            int elem = q.poll();
            if (covered[elem]) continue;
            int provider = -1;
            for (int s : providers[elem]) if (!forcedSet[s]) { provider = s; break; }
            if (provider == -1) { impossible = true; break; }
            forcedSet[provider] = true;
            for (int e : sets[provider]) {
                if (!covered[e]) {
                    covered[e] = true;
                    for (int s : providers[e]) {
                        cnt[e]--;
                    }
                }
            }
        }
        if (impossible) { out.println("NO"); return; }
        for (int x = 1; x <= m; ++x) if (!covered[x] && cnt[x] == 0) { out.println("NO"); return; }
        int remainingSets = 0;
        for (int i = 0; i < n; ++i) if (!forcedSet[i]) remainingSets++;
        out.println(remainingSets >= 2 ? "YES" : "NO");
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
