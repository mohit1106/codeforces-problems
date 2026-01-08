import java.io.*;
import java.util.*;

public class F_Eating_Candies {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] w = new int[n];
        for(int i=0;i<n;i++){
            w[i] = in.nextInt();
        }

        int res = 0;
        int a = w[0], b= w[n-1];
        int i=0, j= n-1;
        while (i < j) {
            if(a== b){
            res = Math.max(res, i+1+n-j);
        }
        if (a <= b) {
            i++;
            a += w[i];
        } else if (a > b) {
            j--;
            b += w[j];
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