import java.io.*;
import java.util.*;

public class G_1_Dances_Easy_version {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
            int m = in.nextInt();  // always 1

            int[] a = new int[n];
            a[0] = 1;   
            for (int i = 1; i < n; i++) a[i] = in.nextInt();

            int[] b = new int[n];
            for (int i = 0; i < n; i++) b[i] = in.nextInt();

            Arrays.sort(a);  
            Arrays.sort(b);  

             for (int i = 0, j = n - 1; i < j; i++, j--) {
                int tmp = b[i];
                b[i] = b[j];
                b[j] = tmp;
            }

            int low = 0, high = n;

            // binary search minimal ops
            while (low < high) {
                int mid = (low + high) / 2;
                if (can(mid, a, b)) high = mid;
                else low = mid + 1;
            }

            System.out.println(low);
    }
    static boolean can(int ops, int[] a, int[] bDesc) {
        int keep = a.length - ops; 

        for (int i = 0; i < keep; i++) {
             
            if (a[i] >= bDesc[keep - 1 - i]) return false;
        }
        return true;
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