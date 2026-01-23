import java.io.*;
import java.util.*;

public class H_Maximal_AND {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        long res = 0;
        for(int bit = 30; bit >=0; bit--){
            int notset = 0;
            for(int a : arr){
                if((a&(1<<bit)) == 0){
                    notset++;
                }
            }
            if(k>= notset){
                res+=(1<<bit);
                k -= notset;
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