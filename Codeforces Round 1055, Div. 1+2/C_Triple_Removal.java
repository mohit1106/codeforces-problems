import java.io.*;
import java.util.*;

public class C_Triple_Removal {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n + 1];
        for (int i=1; i<=n; ++i) a[i] = in.nextInt();

        int[] prefixZeros = new int[n+1];
        for (int i =1; i<=n; ++i) {
            prefixZeros[i] = prefixZeros[i-1] + (a[i]==0?1:0);
        }
        int[] samePrefix = new int[n + 1];
        samePrefix[1] = 0;
        for (int i = 2; i <= n; ++i) {
            samePrefix[i] = samePrefix[i - 1] + (a[i] == a[i - 1] ? 1 : 0);
        }

        for (int qi=0; qi<q; ++qi) {
            int l = in.nextInt();
            int r = in.nextInt();
            int len = r-l+1;
            int zeros = prefixZeros[r] -prefixZeros[l-1];
            int ones = len- zeros;
            if (zeros% 3 !=0||ones%3!= 0) {
                out.println(-1);
                continue;
            }
            int ans = len / 3;
            int equalPairs = samePrefix[r]-samePrefix[l]; 
            boolean isAlternating = (equalPairs==0);
            if (isAlternating && (len % 6==0)) ans++;
            out.println(ans);
        }
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
