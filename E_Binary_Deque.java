import java.io.*;
import java.util.*;

public class E_Binary_Deque {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int s = in.nextInt();

        int[] arr = new int[n];
        int totalSum = 0;

        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
            totalSum += arr[i];
        }
        if(totalSum < s) {
            System.out.println(-1);
            return;
        }if(totalSum == s) {
            System.out.println(0);
            return;
        }

        int l=0, curr = 0, maxLen = -1;
        for(int r=0; r<n; r++) {
            curr = curr + arr[r];
            while(curr > s){
                curr = curr - arr[l++];
            }
            if(curr == s){
                maxLen = Math.max(maxLen, r-l+1);
            }
        }
        if(maxLen == -1){
            System.out.println(-1);
        }else{
            System.out.println(n - maxLen);
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