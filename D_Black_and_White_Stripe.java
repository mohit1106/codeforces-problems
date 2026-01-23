import java.io.*;
import java.util.*;

public class D_Black_and_White_Stripe {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int k= in.nextInt();
        if(k>n) {
            System.out.println(-1);
            return;
        }
        String str = in.next();
        int b = 0, w=0;
        for(char ch : str.toCharArray()){
            if(ch == 'B') b++;
            if(ch == 'w') w++;
        }
        
        int curr = 0;
        for(int i=0; i<k; i++){
            if(str.charAt(i) == 'W') curr++; 
        }

        int min = curr;
        for(int i=k; i<n; i++){
            if(str.charAt(i) == 'W') curr++;
            if(str.charAt(i-k) == 'W') curr--;
            min = Math.min(min, curr);
        }
        System.out.println(min);
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