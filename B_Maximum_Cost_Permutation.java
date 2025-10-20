import java.io.*;
import java.util.*;

public class B_Maximum_Cost_Permutation {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] arr = new int[n+1];

        int zeros = 0;
        boolean[] exists = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
            if(arr[i] == 0) zeros++;
            else exists[arr[i]] = true;
        }

        int missingval=-1;
        if(zeros==1){
            for(int i=1;i<=n;i++){
                if(!exists[i]) { missingval=i; break; }
            }
        }

        int first=-1,last=-1;
        for (int i = 1; i <=n; i++) {
            boolean canmiss= false;
            if(arr[i] !=0){
                if(arr[i]!=i) canmiss = true;
            } else{
                if(zeros>=2) canmiss=true;
                else { if(missingval != i) canmiss=true; }
            }

            if(canmiss){
                if(first==-1) first=i;
                last = i;
            }
        }
        if(first==-1) System.out.println(0);
        else System.out.println((last-first+1));
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