import java.io.*;
import java.util.*;

public class C_1_XOR_Convenience_Easy_Version {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] p = new int[n + 1];
        int idx = 1;

        for (int i = n; i >= 1; ) {
            int msb = Integer.highestOneBit(i);
            int l = msb;
            int r = i;

            for (int x = r; x >= l; --x) {
                p[idx++] = x;
            }
            i = l - 1;
        }

        for (int i = 1; i <= n; i++) {
            if (i > 1) out.print(" ");
            out.print(p[i]);
        }
        out.println();
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }
}
