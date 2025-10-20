import java.io.*;
import java.util.*;

public class C_Array_Game {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n= in.nextInt();
        long k = in.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        if(k>=3){
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);
        long d = arr[0];
        for (int i = 0; i < n - 1; i++)
            d = Math.min(d, arr[i + 1] - arr[i]);

        if (k == 1) {
            System.out.println(d);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long v =arr[i] -arr[j]; 
                int p = Arrays.binarySearch(arr, v);
                if (p < 0) p = -p - 1; 
                if (p < n) d = Math.min(d, arr[p] - v);
                if (p > 0) d = Math.min(d, v - arr[p - 1]);
            }
        }

        System.out.println(d);
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