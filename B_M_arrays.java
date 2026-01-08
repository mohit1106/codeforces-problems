import java.io.*;
import java.util.*;

public class B_M_arrays {
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
        int[] count = new int[m];
        for (int i = 0; i < n; i++) {
            int val = in.nextInt() % m;
            count[val]++;
        }
        int ans = 0;
        if (count[0] > 0) ans++;

        for (int r = 1; r * 2 < m; r++) {
            int x = count[r];
            int y = count[m - r];
            if (x == 0 && y == 0) continue;
            if (x == 0 || y == 0) {
                ans += x + y;
            } else {
                ans += 1 + Math.max(0, Math.abs(x - y) - 1);
            }
        }

        if (m % 2 == 0 && count[m / 2] > 0) ans++;
        System.out.println(ans);
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