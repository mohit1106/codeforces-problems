import java.io.*;
import java.util.*;

public class F_Greetings {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static class BIT {
        long[] tree;
        int n;

        BIT(int size) {
            n = size + 2; 
            tree = new long[n];
        }

        void update(int i, long val) {
            while (i < n) {
                tree[i] += val;
                i += i & -i;
            }
        }

        long query(int i) { 
            long sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }

        long queryRange(int l, int r) { 
            return query(r) - query(l - 1);
        }
    }

    static void solve() {
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        int[] starts = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
            starts[i] = arr[i][0];
        }

        int[] sorted = starts.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> compress = new HashMap<>();
        for (int i = 0; i < n; i++) compress.put(sorted[i], i + 1);

        Arrays.sort(arr, (a,b) -> Integer.compare(a[1], b[1]));

        BIT bit = new BIT(n);
        long meets = 0;

        for (int i = 0; i < n; i++) {
            int compStart = compress.get(arr[i][0]);
            meets += bit.query(n) - bit.query(compStart);
            bit.update(compStart, 1);
        }
        System.out.println(meets);
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