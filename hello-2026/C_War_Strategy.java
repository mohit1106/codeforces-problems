import java.io.*;
import java.util.*;

public class C_War_Strategy {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        long n = in.nextLong();
        long m = in.nextLong();
        long k = in.nextLong();

        long L =k-1;     
        long R =n-k;     
        long best=1;   

        long M = m+1;     
        for (long a=0; a<=L; ++a) {
            long bMax = Long.MIN_VALUE;
            if (a==0) {
                 bMax = M/2;
                if (bMax<0) bMax=0;
                if (bMax>R) bMax = R;
            } else {
                 if (M-2*a>=0) {
                    long cand = Math.min(a, M-2*a);
                    if (cand > bMax) bMax = cand;
                }
                 long tmp = (M-a)/2;
                if (tmp>=a) {
                    if (tmp > bMax) bMax = tmp;
                }
                if (bMax <0) continue;  
                if (bMax>R) bMax = R;
            }

            long val = 1+a+bMax;
            if (val > n) val = n;
            if (val > best) best = val;
        }

        System.out.println(best);
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