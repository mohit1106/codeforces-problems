import java.io.*;
import java.util.*;

public class A_Equal_Occurrences {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = in.nextInt();
            }
            Map<Integer, Integer> freq=new HashMap<>();
            for (int x : a) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            int maxBalanced = 0;
            for (int f=1; f<=n; f++) {
                int count=0;
                for (int val:freq.values()) {
                    if (val>=f) count++;
                }
                maxBalanced = Math.max(maxBalanced, count*f);
            }

            System.out.println(maxBalanced);
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