import java.io.*;
import java.util.*;

public class B_Yet_Another_MEX_Problem {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; ++i) a[i] = in.nextInt();
        boolean[] seen = new boolean[n+2]; 
        for (int v:a) {
            if (v>=0 && v<=n) seen[v] = true;
        }
        int mex = 0;
        while (mex<=n && seen[mex]) mex++;
        int ans = Math.min(mex, k-1);
        System.out.println(ans);
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