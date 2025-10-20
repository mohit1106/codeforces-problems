import java.io.*;
import java.util.*;

public class B_Omkar_and_Last_Class_of_Math {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        long n = in.nextLong();
        long bes = 1;
        long limit = (long) Math.sqrt(n);

        for (long i = 1; i <=limit; i++) {
            if(n%i==0){
                long d1 = i;
                long d2 = n/i;
                if(d1 <=n/2 && d1>bes) bes = d1;
                if(d2 <=n/2 && d2>bes) bes = d2;

            }
        }
        long a=bes;
        long b = n-bes;
        System.out.println(a + " " + b);
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