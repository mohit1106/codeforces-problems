import java.io.*;
import java.util.*;

public class D_Districts_Connection {
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
        boolean allSame = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i-1]) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        for (int i = 0; i < n; i++) {
            if(arr[0] != arr[i]){
                System.out.println("1" + " " + (i+1));
            }
        }

        int different = arr[0];
        int differentLoc = 1;
        for (int i = 0; i < n; i++) {
            if(different != arr[i]){
                different = arr[i];
                differentLoc = i+1;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            if(arr[i] == arr[0]){
                System.out.println(differentLoc + " " + (i+1));
            }
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