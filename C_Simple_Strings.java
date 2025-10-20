import java.io.*;
import java.util.*;

public class C_Simple_Strings {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        solve();
    }

    static void solve() {
        String str = in.next();
        int n = str.length();
        char[] arr = str.toCharArray();

        for(int i=1 ; i<n; i++){
            if(arr[i] == arr[i-1]){
                for(char c = 'a'; c<= 'z'; c++){
                    if(c!= arr[i-1] && (i + 1 == n || c != arr[i + 1])){
                        arr[i] = c;
                        break;
                    }
                }
            }
        }
        System.out.println(new String(arr));
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