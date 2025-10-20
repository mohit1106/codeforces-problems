import java.io.*;
import java.util.*;

public class F_Yet_Another_Problem_About_Pairs_Satisfying_an_Inequality {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }

        long res = 0;
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            if(arr[i]>=i) continue;
            
            int pos = Collections.binarySearch(v, arr[i]);
            if(pos<0) pos= -pos-1;
            res += pos;
            v.add(i);
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