import java.io.*;
import java.util.*;

public class C_Stable_Groups {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        long k = in.nextLong(), x = in.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = in.nextLong();
        Arrays.sort(a);

        List<Long> gaps = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            long diff = a[i] - a[i - 1];
            if (diff > x) {
                long need = (diff - 1) / x;
                gaps.add(need);
            }
        }

        Collections.sort(gaps);
        long groups = gaps.size() + 1;

        for (long g : gaps) {
            if (k >= g) {
                k -= g;
                groups--;
            } else break;
        }

        out.println(groups);
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
