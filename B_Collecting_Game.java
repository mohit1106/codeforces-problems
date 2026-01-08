import java.io.*;
import java.util.*;

public class B_Collecting_Game {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = in.nextLong();

        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = a[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingLong(x -> x[0]));

        long[] b = new long[n];
        for (int i = 0; i < n; i++) b[i] = arr[i][0];

        long[] pref = new long[n];
        pref[0] = b[0];
        for (int i = 1; i < n; i++) pref[i] = pref[i - 1] + b[i];

        int[] maxReach = new int[n];
        maxReach[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (pref[i] >= b[i + 1]) {
                maxReach[i] = maxReach[i + 1];
            } else {
                maxReach[i] = i;
            }
        }

         long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            int pos = i;
            int reach = maxReach[pos];
            ans[(int) arr[i][1]] = reach;
        }

        for (long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
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