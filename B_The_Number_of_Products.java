import java.io.*;
import java.util.*;

public class B_The_Number_of_Products {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        solve();
    }

    static void solve() {
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        long pos = 0, neg=0;
        long cnt0 = 1, cnt1=0;

        int[] prefix = new int[n];
        prefix[0] = (arr[0]>0 ? 0 : 1);

        for (int i = 1; i < n; i++) {
            prefix[i]  = prefix[i-1] ^ (arr[i] > 0? 0:1);
        }

        for (int i = 0; i < n; i++) {
            if(prefix[i] == 0) {
                pos += cnt0;
                neg += cnt1;
                cnt0++;
            }  else{
                pos += cnt1;
                neg += cnt0;
                cnt1++;
            }
        }
        System.out.println(neg + " " + pos);
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