import java.io.*;
import java.util.*;

public class B_Pleasant_Pairs {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] pos = new int[2*n +1];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            pos[arr[i]] = i+1;
        }

        int cnt=0;
        for(int i=0; i<n; i++){
            int ai = arr[i];
            for (int m = ai; m <=2*n; m+=ai) {
                int j = pos[m/ai];
                if (j > 0 && j > i + 1) { 
                    if ((long) ai * (m / ai) == (i + 1) + j) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);

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