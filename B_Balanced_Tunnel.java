import java.io.*;
import java.util.*;

public class B_Balanced_Tunnel {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt() - 1;
        for (int i = 0; i < n; i++) b[i] = in.nextInt() - 1;

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) pos[b[i]] = i;

        int[] c = new int[n];
        for (int i = 0; i < n; i++) c[i] = pos[a[i]];

        int mx = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] > mx) {
                mx = c[i];
            } else {
                ans++;
            }
        }

        out.println(ans);
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