import java.io.*;
import java.util.*;

public class E_1_Rudolf_and_Snowflakes_simple_version {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        if(n<7){
            System.out.println("NO");
            return;
        }
        
        for(int k=2; k<=1000; k++){
            int vertices = 1;
            int term = 1;
            int minreq = 1+k+(k*k);
            if(n<minreq){
                System.out.println("NO");
                return;
            }
            while(vertices<n){
                term = term*k;

                vertices += term;
                if(vertices == n){
                    System.out.println("YES");
                    return;
                }
            }
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