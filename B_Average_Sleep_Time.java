import java.io.*;
import java.util.*;

public class B_Average_Sleep_Time {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n+1];
        long[] prefix = new long[n+1];

        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            prefix[i] = prefix[i-1] + a[i];
        }

        double total = 0;
        for (int i = k; i <= n; i++) {
            total += prefix[i] - prefix[i-k];
        }

        double avg = total / (n - k + 1);
        System.out.printf("%.10f\n", avg);
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