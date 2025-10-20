import java.io.*;
import java.util.*;

public class C_Paint_the_Array {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }

        long gcd1 = arr[0];
        long gcd2 = arr[1];
        for(int i=2; i<n; i += 2){
            gcd1 = findGCD(gcd1, arr[i]);
            if(gcd1 ==1) break;
        }
        for(int i=3; i<n; i += 2){
            gcd2 = findGCD(gcd2, arr[i]);
            if(gcd2 ==1) break;
        }

        boolean res1 = true;
        boolean res2 = true;

        for (int i = 1; i < n; i += 2) {
            if(arr[i] %gcd1 == 0){
                res1 = false;
                break;
            }
        }
        for (int i = 0; i < n; i += 2) {
            if(arr[i] %gcd2 == 0){
                res2 = false;
                break;
            }
        }

        if(res1){
            System.out.println(gcd1);
        } else if(res2){
            System.out.println(gcd2);
        } else{
            System.out.println(0);
        }

    }

    public static long findGCD(long a, long b){
        while(b!= 0){
            long temp = a%b;
            a=b;
            b= temp;
        }
        return a;
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