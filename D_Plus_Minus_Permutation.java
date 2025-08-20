import java.io.*;
import java.util.*;

public class D_Plus_Minus_Permutation {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        long n = in.nextLong();
        long x = in.nextLong();
        long y = in.nextLong();

        long gcd = findGcd(x, y);
        long lcm = x / gcd * y;

        long cntDivisibleByBoth = n/lcm;
        long cntDivisibleByX = n/x - cntDivisibleByBoth;
        long cntDivisibleByY = n/y - cntDivisibleByBoth;

        long sumLargestX = 0;
        if (cntDivisibleByX > 0) {
            sumLargestX = sumFirst(n) - sumFirst(n - cntDivisibleByX);
        }

        long sumSmallestY = 0;
        if (cntDivisibleByY > 0) {
            sumSmallestY = sumFirst(cntDivisibleByY);
        }

        System.out.println(sumLargestX - sumSmallestY);
    }

    static long findGcd(long a, long b){
        while(b!=0){
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long sumFirst(long m){
        return m * (m + 1) / 2;
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