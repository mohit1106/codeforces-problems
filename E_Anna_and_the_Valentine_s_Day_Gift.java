import java.io.*;
import java.util.*;

public class E_Anna_and_the_Valentine_s_Day_Gift {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
    int m = in.nextInt();
    String[] arr = new String[n];
    int[] len = new int[n];
    int[] zrr = new int[n];

    for (int i = 0; i < n; i++) {
        arr[i] = in.next();
        len[i] = arr[i].length();
        int cnt = 0;
        for (int j = arr[i].length() - 1; j >= 0 && arr[i].charAt(j) == '0'; j--) {
            cnt++;
        }
        zrr[i] = cnt;
    }

    long ans = 0;
    for (int i = 0; i < n; i++) {
        ans += len[i] - zrr[i];
    }

    Arrays.sort(zrr);
    for (int i = 0; i < n / 2; i++) {
        int tmp = zrr[i];
        zrr[i] = zrr[n - 1 - i];
        zrr[n - 1 - i] = tmp;
    }

    for (int i = 0; i < n; i++) {
        if ((i & 1) == 1) ans += zrr[i];
    }

    System.out.println(ans - 1 >= m ? "Sasha" : "Anna");
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