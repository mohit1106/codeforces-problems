import java.io.*;
import java.util.*;

public class E_Romantic_Glasses {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        long[] arr = new long[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextLong();
        }

        long prefix = 0;
        Set<Long> seen = new HashSet<>();
        seen.add(0L);
        for(int i=1; i<=n; i++){
            if(i%2==0){
                prefix -= arr[i];
            } else{
                prefix += arr[i];
            }

            if(seen.contains(prefix)){
                System.out.println("YES");
                return;
            }
            seen.add(prefix);
        }
        System.out.println("NO");
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