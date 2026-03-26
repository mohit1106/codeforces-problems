import java.io.*;
import java.util.*;

public class A_Weird_Sum {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        int maxColor = 100000;

        ArrayList<Integer>[] rows = new ArrayList[maxColor+1];
        ArrayList<Integer>[] cols = new ArrayList[maxColor+1];

        for (int i = 0; i <=maxColor; i++) {
            rows[i] = new ArrayList<>();
            cols[i] = new ArrayList<>();
        }

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                int color = in.nextInt();
                rows[color].add(r);
                cols[color].add(c);
            }
        }

        long ans = 0;
        for(int color = 1; color <= maxColor; color++){
            if(rows[color].size() < 2) continue;

            ans += computeSum(rows[color]);
            ans += computeSum(cols[color]);

        }
        System.out.println(ans);
    }

    public static long computeSum(ArrayList<Integer> list){
        Collections.sort(list);

        long sum = 0, prefix=0;
        for(int i=0; i<list.size(); i++){
            long v= list.get(i);
            sum += v*i - prefix;

            prefix += v;
        }
        return sum;
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