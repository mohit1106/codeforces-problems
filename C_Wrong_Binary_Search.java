import java.io.*;
import java.util.*;

public class C_Wrong_Binary_Search {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        String s = in.next();

        boolean hasOne = s.indexOf('1') >= 0;
        if (!hasOne) {
            out.println("YES");
            for (int i=1; i<=n; ++i) {
                int val=(i==n) ? 1:i+1;
                out.print(val + (i==n?"\n":" "));
            }
            return;
        }

        boolean bad =false;
        int i=0;
        while (i<n) {
            if (s.charAt(i)=='0') {
                int j=i;
                while (j< n&&s.charAt(j)=='0') j++;
                int len =j -i;
                if (len== 1) { bad = true; break; }
                i = j;
            } else i++;
        }
        if (bad) {
            out.println("NO");
            return;
        }

        int[] p = new int[n + 1]; 
        ArrayList<Integer> zeros = new ArrayList<>();
        int prevOne = 0;
        for (int idx = 1; idx <= n; ++idx) {
            if (s.charAt(idx - 1) == '0') {
                zeros.add(idx);
            } else {
                int len = zeros.size();
                if (len > 0) {
                    for (int k = 0; k < len; ++k) {
                        int pos = zeros.get(k);
                        int val = zeros.get((k + 1) % len); // next position's index (value)
                        p[pos] = val;
                    }
                    zeros.clear();
                }
                p[idx] = idx; 
                prevOne = idx;
            }
        }
        int len = zeros.size();
        if (len > 0) {
            for (int k = 0; k < len; ++k) {
                int pos = zeros.get(k);
                int val = zeros.get((k + 1) % len);
                p[pos] = val;
            }
            zeros.clear();
        }

        out.println("YES");
        for (int idx = 1; idx <= n; ++idx) {
            out.print(p[idx] + (idx == n ? "\n" : " "));
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
