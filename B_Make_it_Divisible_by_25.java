import java.io.*;
import java.util.*;

public class B_Make_it_Divisible_by_25 {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        String n = in.next();
        String[] targets = {"00", "25", "50", "75"};
        int ans = Integer.MAX_VALUE;
        for (String target : targets) {
            char d2 = target.charAt(1); 
            char d1 = target.charAt(0); 

            for (int j = n.length() - 1; j >= 0; j--) {
                if (n.charAt(j) == d2) {
                    for (int i = j - 1; i >= 0; i--) {
                        if (n.charAt(i) == d1) {
                            int deletions = (n.length() - i - 2);
                            ans = Math.min(ans, deletions);
                            break; 
                        }
                    }
                }
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