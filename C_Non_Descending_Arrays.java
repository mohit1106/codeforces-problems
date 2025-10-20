import java.io.*;
import java.util.*;

public class C_Non_Descending_Arrays {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    static final long MOD = 998244353L;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.print(sb.toString());
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }

        long[] dpPrev = new long[2];
        dpPrev[0] = 1;
        dpPrev[1] = 1;

        for (int i = 1; i < n; i++) {
            long[] dpCur = new long[2];
            
            int x0 = a[i-1], y0 = b[i-1];

            int x1 = b[i-1], y1 = a[i-1];
            int tx0 = a[i], ty0 = b[i];
            int tx1 = b[i], ty1 = a[i];

            if (x0<=tx0 && y0<=ty0) dpCur[0]=(dpCur[0]+dpPrev[0]) % MOD;
            if (x1<=tx0 && y1<=ty0) dpCur[0]=(dpCur[0]+dpPrev[1]) % MOD;
            if (x0<=tx1 && y0<=ty1) dpCur[1]=(dpCur[1]+dpPrev[0]) % MOD;
            if (x1<=tx1 && y1<=ty1) dpCur[1]=(dpCur[1]+dpPrev[1]) % MOD;

            dpPrev = dpCur;
        }

        long ans = (dpPrev[0] + dpPrev[1]) % MOD;
        sb.append(ans).append('\n');
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