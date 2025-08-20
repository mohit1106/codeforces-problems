import java.io.*;
import java.util.*;

public class A_Three_Indices {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int mid = -1, first = -1, last = -1;
        for(int j = 1; j<(n-1); j++){
            int f = -1, l = -1;
            for(int i=0; i<j; i++){
                if(arr[i] < arr[j]){
                    f = i;
                    break;
                }
            }
            for(int k=j+1; k<n; k++){
                if(arr[k] < arr[j]){
                    l = k;
                    break;
                }
            }
            if(f != -1 && l != -1){
                first = f;
                last = l;
                mid = j;
                break;
            }
        }

        if(first!=-1){
            System.out.println("YES");
            System.out.println((first+1) + " " + (mid+1) + " " + (last+1));
        } else {
            System.out.println("NO");
        }
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