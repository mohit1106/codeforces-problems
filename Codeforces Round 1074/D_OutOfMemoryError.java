import java.io.*;
import java.util.*;

public class D_OutOfMemoryError {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        int h = in.nextInt();
        
        int[] org = new int[n];
        int[] arr = new int[n];
        int[] last = new int[n];

        for (int i = 0; i < n; i++) {
            org[i] = in.nextInt();
            arr[i] = org[i];
            last[i] = 0;
        }
        int loopNo = 0;
        for(int i=0; i<m; i++){
            int b = in.nextInt()-1;
            int c = in.nextInt();

            if (last[b] != loopNo) {
                arr[b] = org[b];
                last[b] = loopNo;
            }

            if (arr[b] + c > h) {
                loopNo++;
            }else {
                arr[b] = arr[b] + c;
            }
        }
        for (int i = 0; i < n; i++) {
            if(last[i] != loopNo) arr[i] = org[i];
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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