import java.io.*;
import java.util.*;

public class A_Table_with_Numbers {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int h = in.nextInt();
        int l= in.nextInt();
        int validrows=0, validcols=0;
        int invalid=0;

        for (int i = 0; i < n; i++) {
            int ai= in.nextInt();
            if(ai <= h) validrows++;
            if(ai<=l) validcols++;
            if(ai>h && ai>l) invalid++;
        }
        System.out.println(Math.min(Math.min(validcols, validrows), (n-invalid)/2));
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