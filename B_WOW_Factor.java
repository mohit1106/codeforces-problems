import java.io.*;
import java.util.*;

public class B_WOW_Factor {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        solve();
        out.flush();
    }

    static void solve() {
        String s = in.next();
        int n = s.length();
        long[] prefixW = new long[n+1];
        long[] suffixW = new long[n+2];

        for (int i=1; i<n; i++) {
            prefixW[i] = prefixW[i-1];
            if (s.charAt(i) == 'v' && s.charAt(i-1) == 'v') {
                prefixW[i]++;
            }
        }
        prefixW[n] = prefixW[n-1];

        for (int i = n-2; i >= 0; i--) {
            suffixW[i] = suffixW[i+1];
            if (s.charAt(i) == 'v' && s.charAt(i+1) == 'v') {
                suffixW[i]++;
            }
        }
        long ans = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='o'){
                ans += prefixW[i]*suffixW[i];
            }
        }
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