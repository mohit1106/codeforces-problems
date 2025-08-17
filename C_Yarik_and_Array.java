import java.io.*;
import java.util.*;

public class C_Yarik_and_Array {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();

        int ans = a[0];
        int mn = Math.min(0, a[0]);
        int sum = a[0];

        for (int i = 1; i < n; i++) {
            if (Math.abs(a[i] % 2) == Math.abs(a[i - 1] % 2)) {
                // Bad position → reset
                mn = 0;
                sum = 0;
            }
            sum += a[i];
            ans = Math.max(ans, sum - mn);
            mn = Math.min(mn, sum);
        }

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