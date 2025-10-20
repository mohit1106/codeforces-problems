import java.io.*;
import java.util.*;

public class D_Buying_Shovels {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        long n = in.nextLong();
        long k = in.nextLong();

        if(k>=n){
            System.out.println(1);
            return;
        }

        long maxDiv = 1;
        for(long i=1; i*i <= n; i++){
            if(n%i == 0){
                long div1 = i;
                long div2 = n/i;
                if(div1 <= k) maxDiv = Math.max(maxDiv, div1);
                if(div2 <= k) maxDiv = Math.max(maxDiv, div2);
            }
        }
        System.out.println(n/maxDiv);
    }

    static List<Long> getFactors(long n) {
        List<Long> factors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add((long) i);               
                if (i != n / i)              
                    factors.add((long) (n/i));     
            }
        }
        Collections.sort(factors);  
        return factors;
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