import java.io.*;
import java.util.*;

public class C_Make_it_Alternating {
    static final int MOD = 998244353;
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();
    static long[] fact;

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        int MAX = 200000;
        fact = new long[MAX + 1];
        fact[0] = 1;
        for (int i = 1; i <= MAX; i++) fact[i] = fact[i - 1] * i % MOD;

        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        String s = in.next();
        int n = s.length();
        long prod = 1;
        int blocks = 0;

        for (int l = 0; l < n; ) {
            int r = l + 1;
            while (r < n && s.charAt(r) == s.charAt(l)) r++;
            int len = r - l;
            prod = prod * len % MOD;
            blocks++;
            l = r;
        }

        int deletions = n - blocks;
        long ans = prod * fact[deletions] % MOD;
        out.println(deletions + " " + ans);
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
    }
}
