import java.io.*;
import java.util.*;

public class E_Mirror_Grid {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        int operations = 0;
        for (int i = 0; i < n / 2 + n % 2; i++){
            for (int j = 0; j < n / 2; j++) {
                int[] count = new int[2];
                int[][] cells = {
                    {i, j},
                    {j, n - 1 - i},
                    {n - 1 - i, n - 1 - j},
                    {n - 1 - j, i}
                };
                for (int[] c : cells) {
                    count[grid[c[0]][c[1]] - '0']++;
                }
                operations += Math.min(count[0], count[1]);
            }
        }
        System.out.println(operations);
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