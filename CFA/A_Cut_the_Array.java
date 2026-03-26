import java.io.*;
import java.util.*;

public class A_Cut_the_Array {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }

        for(int l=1; l<n-1; l++){
            for (int r = l+1; r < n; r++) {

                int sumprefix = 0;
                for(int i=1; i<=l; i++){
                    sumprefix += arr[i];
                }
                int s1 = sumprefix%3;
                int summiddle = 0;
                for(int i=l+1; i<=r; i++){
                    summiddle += arr[i];
                }
                int s2 = summiddle%3;
                int sumsuffix = 0;
                for(int i=r+1; i<=n; i++){
                    sumsuffix += arr[i];
                }
                int s3 = sumsuffix%3;

                if(s1 == s2 && s2 == s3){
                    System.out.println(l + " " + r);
                    return;
                } else if(s1 != s2 && s1 != s3 && s2 != s3){
                    System.out.println(l + " " + r);
                    return;
                }
            }
        }
        System.out.println(0 + " " + 0);
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