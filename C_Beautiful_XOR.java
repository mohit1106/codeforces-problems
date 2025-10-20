import java.io.*;
import java.util.*;

public class C_Beautiful_XOR {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        long a = in.nextLong();
        long b = in.nextLong();

        if (a == b) {
            out.println(0);
            return;
        }

        int hbA = highestBit(a);
        int hbB = highestBit(b);
        if (hbB > hbA) {
            out.println(-1);
            return;
        }

        ArrayList<Long> ops = new ArrayList<>();        for (int bit = 31; bit >= 0; --bit) {
            long mask = 1L << bit;
            if (((b & mask) != 0) && ((a & mask) == 0)) {
                ops.add(mask);
                a ^= mask;
            }
        }
        for (int bit = 31; bit >= 0; --bit) {
            long mask = 1L << bit;
            if (((b & mask) == 0) && ((a & mask) != 0)) {
                ops.add(mask);
                a ^= mask;
            }
        }

        if (a != b) {
            out.println(-1);
        } else {
            out.println(ops.size());
            if (!ops.isEmpty()) {
                for (int i = 0; i < ops.size(); ++i) {
                    if (i > 0) out.print(' ');
                    out.print(ops.get(i));
                }
                out.println();
            }
        }
    }

    public static int highestBit(long x) {
        if (x == 0) return -1;
        for (int i = 31; i >= 0; --i) if (((x >> i) & 1L) == 1L) return i;
        return -1;
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
    }
}
