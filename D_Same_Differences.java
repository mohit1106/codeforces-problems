import java.io.*;
import java.util.*;

public class D_Same_Differences {
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
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            diff[i] = arr[i] - (i+1);
        }

        HashMap<Integer, Long> map = new HashMap<>();
        for (int a : diff) {
            map.put(a, map.getOrDefault(a, 0L)+1);
        }
        long res =0;

        for(long val : map.values()){
            if(val > 1){
                res += ((val)*(val-1))/2;
            }
        }
        System.out.println(res);

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