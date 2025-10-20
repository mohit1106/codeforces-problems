import java.io.*;
import java.util.*;

public class B_Tenzing_and_Books {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int x = in.nextInt();

        int[][] stacks = new int[3][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                stacks[i][j] = in.nextInt();
            }
        }

        int knowledge = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                if((stacks[i][j] | x) == x){
                    knowledge = knowledge | stacks[i][j];
                }
                else{
                    break;
                }
            }
        }
        if (knowledge == x) {
            System.out.println("Yes");
        } else{
            System.out.println("No");
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