import java.io.*;
import java.util.*;

public class C_Ball_in_Berland {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int a = in.nextInt();
        int b = in.nextInt();
        int k = in.nextInt();

        int[] boys = new int[k];
        int[] girls = new int[k];

        for (int i = 0; i < k; i++) {
            boys[i] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            girls[i] = in.nextInt();
        }
        long[] cntB = new long[a+1];
        long[] cntG = new long[b+1];
        for (int i = 0; i < k; i++) {
            cntB[boys[i]]++;
            cntG[girls[i]]++;
        }
        long ans = 0;
    for (int i = 0; i < k; i++) {
        long bad = (cntB[boys[i]] - 1) + (cntG[girls[i]] - 1);
        ans += (k - 1 - bad);
    }
    System.out.println(ans / 2);
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