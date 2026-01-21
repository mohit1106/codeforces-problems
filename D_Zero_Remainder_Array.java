import java.io.*;
import java.util.*;

public class D_Zero_Remainder_Array {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
         int n=in.nextInt();
        long k=in.nextLong();

        HashMap<Long, Long> freq=new HashMap<>();

        for (int i=0; i < n; i++) {
            long a=in.nextLong();
            long need=(k - (a % k)) % k;
            if (need != 0) {
                freq.put(need, freq.getOrDefault(need, 0L) + 1);
            }
        }

        long ans=0;

        for (Map.Entry<Long, Long> e : freq.entrySet()) {
            long r=e.getKey();
            long cnt=e.getValue();
            long cur=r + k * (cnt - 1) + 1;
            ans=Math.max(ans, cur);
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