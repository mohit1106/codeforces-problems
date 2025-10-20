import java.io.*;
import java.util.*;

public class B_Deck_of_Cards {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();

        if (k == n) {
            char[] allRemoved = new char[n];
            Arrays.fill(allRemoved, '-');
            out.println(new String(allRemoved));
            return;
        }

        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') cnt0++;
            else if (c == '1') cnt1++;
            else cnt2++;
        }

        int lowL = cnt0 + 1;           
        int highL = cnt0 + cnt2 + 1; 

        int unionL = lowL;
        int unionR = n - cnt1;       

        int interL = highL;
        int interR = n - cnt1 - cnt2;

        char[] res = new char[n];
        for (int i = 1; i <= n; i++) {
            if (i<unionL|| i > unionR) {
                res[i-1] = '-';
            } else if (interL <= interR && i >= interL && i <= interR) {
                res[i-1] = '+';
            } else {
                res[i-1] = '?';
            }
        }

        out.println(new String(res));
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