import java.io.*;
import java.util.*;

public class C_Make_Them_Equal {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        char c = in.next().charAt(0);
        String str  = in.next();
        
        boolean isAllEqual = true;
        for(char a : str.toCharArray()){
            if(a!= c){
                isAllEqual = false;
                break;
            }
        }
        if (isAllEqual) {
            System.out.println(0);
            return;
        }

        for (int x = 2; x <=n; x++) {
            boolean ok = true;
            for (int i = x; i <=n; i+=x) {
                if(str.charAt(i-1)!=c){
                    ok = false;
                    break;
                }
            }
            if(ok){
                System.out.println(1);
                System.out.println(x);
                return;
            }
        }

            System.out.println(2);
            System.out.println(n + " " + (n-1));
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