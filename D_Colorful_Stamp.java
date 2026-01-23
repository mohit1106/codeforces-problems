import java.io.*;
import java.util.*;

public class D_Colorful_Stamp {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        String str = in.next();

        boolean possible = true;

        String[] parts = str.split("W");
        for(int i=0; i<parts.length; i++){
            if (parts[i].length() == 0) continue;
            if(!parts[i].contains("B") || !parts[i].contains("R")){
                possible = false;
                break;
            }
        }
        if(possible) System.out.println("YES");
        else System.out.println("NO");
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