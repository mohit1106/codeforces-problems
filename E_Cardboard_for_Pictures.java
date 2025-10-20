import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class E_Cardboard_for_Pictures {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        long c = in.nextLong();

        long sum = 0;
        long sumSq = 0;

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
            sum += arr[i];
            sumSq += (arr[i]*arr[i]);
        }
        long left = 1;
        long right = (long)(1e9);
        BigInteger target = BigInteger.valueOf(c);

        while(left <= right){
            long mid = left + (right-left)/2;
            
            BigInteger total = BigInteger.valueOf(sumSq)
            .add(BigInteger.valueOf(4L).multiply(BigInteger.valueOf(n)).multiply(BigInteger.valueOf(mid)).multiply(BigInteger.valueOf(mid)))
            .add(BigInteger.valueOf(4L).multiply(BigInteger.valueOf(mid)).multiply(BigInteger.valueOf(sum)));

            int cmp = total.compareTo(target);
            if(cmp == 0){
                System.out.println(mid);
                return;
            } else if(cmp > 0){
                right = mid-1;
            } else{
                left = mid +1;
            }
        }
        System.out.println(-1);

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