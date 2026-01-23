import java.io.*;
import java.util.*;

public class B_The_Curse_of_the_Frog {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();
    
    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        
        int n=in.nextInt();
        long x=in.nextLong();
        long base=0L;
        long best=Long.MIN_VALUE;
        for (int i=0; i < n; i++) {
            long a=in.nextLong();
            long b=in.nextLong();
            long c=in.nextLong();
            base += a * (b-1);
            long gain=a * b-c; 
            if (gain > best) best=gain;
        }
        if (base>= x) {
            System.out.println(0);
            return;
        } else if (best <= 0) {
            System.out.println(-1);
            return;
        } else {
            long need=x-base;
            long R=(need + best-1)/best;
            System.out.println(R);
            return;
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