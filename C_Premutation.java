import java.io.*;
import java.util.*;

public class C_Premutation {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        // int n= in.nextInt();
        // int[][] seq = new int[n][n-1];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n-1; j++) {
        //         seq[i][j] = in.nextInt();
        //     }
        // }

        // Map<Integer, Integer> count = new HashMap<>();
        // for (int i = 0; i < n; i++) {
        //     count.put(seq[i][0], count.getOrDefault(seq[i][0], 0)+1);
        // } 

        // int first = -1;
        // for (Map.Entry<Integer, Integer> e : count.entrySet()) {
        //     if (e.getValue() > 1) {
        //         first = e.getKey();
        //         break;
        //     }
        // }

        // int[] suffix = null;
        // for (int i = 0; i < n; i++) {
        //     if (seq[i][0] != first) {
        //         suffix = seq[i];
        //         break;
        //     }
        // }

        // out.print(first + " ");
        // for (int x : suffix) out.print(x + " ");
        // out.println();
        int n = in.nextInt();
            int[][] seq = new int[n][n-1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n-1; j++) {
                    seq[i][j] = in.nextInt();
                }
            }

            int a = seq[0][0], countA = 1;
            int b = -1;
            
            for (int i = 1; i < n; i++) {
                if (seq[i][0] == a) countA++;
                else b = seq[i][0];  // store alternative
            }

            int first = (countA > 1) ? a : b;

            // find the sequence that does not start with 'first'
            int[] suffix = null;
            for (int i = 0; i < n; i++) {
                if (seq[i][0] != first) {
                    suffix = seq[i];
                    break;
                }
            }

            out.print(first + " ");
            for (int x : suffix) out.print(x + " ");
            out.println();
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