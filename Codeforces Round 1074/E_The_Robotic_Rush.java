import java.io.*;
import java.util.*;

public class E_The_Robotic_Rush {
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
        int k = in.nextInt();

        long[] a = new long[n];
        for (int i=0; i<n; i++) a[i]=in.nextLong();
        long[] b=new long[m];
        for (int i=0; i<m; i++) b[i]=in.nextLong();
        String gdCode=in.next();

        Map<Long, List<Integer>> deaths = new HashMap<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                long d=b[j] - a[i];
                deaths.computeIfAbsent(d, x -> new ArrayList<>()).add(i);
            }
        }
        boolean[] dead = new boolean[n];
        int alive = n;
        long delta = 0;
        StringBuilder out = new StringBuilder();
        for (int i=0; i<k; i++) {
            delta += (gdCode.charAt(i) == 'R') ? 1 : -1;
            if (deaths.containsKey(delta)) {
                for (int idx : deaths.get(delta)) {
                    if (!dead[idx]) {
                    dead[idx]=true;
                    alive--;
                    }
                }
            }

            out.append(alive).append(' ');
        }
        System.out.println(out.toString());
    }

    static class FastReader {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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