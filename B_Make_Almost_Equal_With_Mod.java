import java.io.*;
import java.util.*;

public class B_Make_Almost_Equal_With_Mod {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    static final long LIMIT = 1_000_000_000_000_000_000L;

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }

        boolean found = false;
        for(int j=1; j<=60; j++){
            long k = 1L << j;
            if(k > LIMIT) break;
            Set<Long> set = new HashSet<>();
            for (long v : arr) {
                set.add(v%k);
            }
            if(set.size() ==2){
                System.out.println(k);
                found=true;
                break;
            }
        }
        if(!found) System.out.println(LIMIT);
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