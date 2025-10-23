import java.io.*;
import java.util.*;

public class B_Just_Eat_It {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        long[] arr = new long[n];
        long totalSum = 0L;

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
            totalSum += arr[i];
        }

        long sum1 = 0L;
        boolean prefixWithNegSum = false;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i];
            if(sum1 <= 0){
                prefixWithNegSum = true;
                break;
            }
        }
        long sum2 = 0L;
        boolean suffixWithNegSum = false;
        for (int i = n-1; i>=0; i--) {
            sum2 += arr[i];
            if(sum2 <= 0){
                suffixWithNegSum = true;
                break;
            }
        }

        if(prefixWithNegSum || suffixWithNegSum){
            System.out.println("NO");
            return;
        } else{
            System.out.println("YES");
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