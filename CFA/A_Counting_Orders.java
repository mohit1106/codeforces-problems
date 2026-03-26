import java.io.*;
import java.util.*;

public class A_Counting_Orders {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final long MOD = 1000000007L;

    static void solve() {
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        for (int i = 0; i < n; i++) b[i] = in.nextInt();

        Arrays.sort(a);
        Arrays.sort(b);

        long ways = 1;
        for(int i=n-1; i>=0; i--){
            int lowerbound = upperBound(a, b[i]);
            int greaters = n-lowerbound;
            int available = greaters - ((n-1)-i);

            if(available <= 0) {
                ways = 0;
                break;
            }
            ways = (ways * available) % MOD; 
        }
        System.out.println(ways);
    }

    public static int upperBound(int[] arr, int val){
        int l=0, r= arr.length;
        while(l<r){
            int mid = l+(r-l)/2;
            if(arr[mid] <= val){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return l;
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