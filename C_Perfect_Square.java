import java.io.*;
import java.util.*;

public class C_Perfect_Square {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        char[][] a = new char[n][n];
        for (int i = 0; i < n; i++)
            a[i] = in.next().toCharArray();
        
        long ops = 0;
        for (int i = 0; i < n / 2; i++) {
             for (int j = 0; j < n / 2; j++) {
                char c1 = a[i][j];
                char c2 = a[j][n - 1 - i];
                char c3 = a[n - 1 - i][n - 1 - j];
                char c4 = a[n - 1 - j][i];

                char max = (char) Math.max(Math.max(c1, c2), Math.max(c3, c4));
                ops += (max - c1) + (max - c2) + (max - c3) + (max - c4);
             }
        }
        System.out.println(ops);
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