import java.io.*;
import java.util.*;

public class C_Dora_and_Search {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n= in.nextInt();
        int[] arr = new int[n];

        int minpos = -1;
        int maxpos = -1;
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
            if(arr[i] == 1) minpos = i;
            if(arr[i] == n) maxpos = i;
        }
        if(n<=2){
            System.out.println(-1);
            return;
        }

        int l = 0;
        int r = n-1;

        int min = 1;
        int max = n;
        boolean found = false;

        while(l<r){
            if(arr[l] == min) {l++; min++;}
            else if(arr[l] == max) {l++; max--;}
            else if(arr[r] == min) {r--; min++;}
            else if(arr[r] == max) {r--; max--;}
            else{
                System.out.println((l+1) + " " + (r+1));
                return;
            }
        }
        
        System.out.println(-1);
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