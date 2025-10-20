import java.io.*;
import java.util.*;

public class B_Catching_the_Krug {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        long n = in.nextLong();
            long rK = in.nextLong();
            long cK = in.nextLong();
            long rD = in.nextLong();
            long cD = in.nextLong();

            long tDown = timeForDir(n, rK, cK, rD, cD,  1,  0);
            long tUp = timeForDir(n, rK, cK, rD, cD, -1,  0);
            long tRight= timeForDir(n, rK, cK, rD, cD,  0,  1);
            long tLeft= timeForDir(n, rK, cK, rD, cD,  0, -1);

            long ans=Math.max(Math.max(tDown,tUp),Math.max(tRight, tLeft));
            System.out.println(ans);

    }

    static long timeForDir(long n, long rK, long cK, long rD, long cD, int dr, int dc) {
        if (dr != 0) {
            long C = Math.abs(cD - cK);
            long T = (dr == 1) ? (n - rK) : rK; 
            long border = (dr == 1) ? n : 0;
            long A = (dr == 1) ? (rD - rK) : (rK - rD);
            if (A >= 0) {
                long t1 = Math.max(C, (A + 1) / 2);
                if (t1 <= T) return t1;
            }
            long t2 = Math.max(C, Math.abs(rD - border));
            return Math.max(T, t2);
        } else {
            long C = Math.abs(rD - rK);
            long T = (dc == 1) ? (n - cK) : cK; 
            long border = (dc == 1) ? n : 0;
            long A = (dc == 1) ? (cD - cK) : (cK - cD);
            if (A >= 0) {
                long t1 = Math.max(C, (A + 1) / 2);
                if (t1 <= T) return t1;
            }
            long t2 = Math.max(C, Math.abs(cD - border));
            return Math.max(T, t2);
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