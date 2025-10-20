import java.io.*;
import java.util.*;

public class C_Product_of_Three_Numbers {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        
        ArrayList<Long> factors = new ArrayList<>();
        long x =n;

        long a = -1;
        for(long i=2; i*i<=x; i++){
            if(x%i==0){
                a=i;
                x=x/i;
                break;
            }
        }
        if(a==-1){
            System.out.println("NO");
            return;
        }

        long b=-1;
        for (long i = a+1; i*i<=x; i++) {
            if(x%i==0){
                b=i;
                x/=i;
                break;
            }
        }
        if(b==-1 || x==1|| x==a||x==b){
            System.out.println("NO");
            return;
        }
        long c =x;
        System.out.println("YES");
        System.out.println(a + " " + b+ " " + c);

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