import java.io.*;
import java.util.*;

public class C_Double_ended_Strings {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        String str1 = in.next();
        String str2 = in.next();
        if(str1.equals(str2)) {
            System.out.println(0);
            return;
        }

        int deleted = 0;
        int n1 = str1.length(), n2 = str2.length();
        boolean foundStart = false;
        
        for(int i=0; i<n1; i++){
            for (int j = 0; j < n2; j++) {
                if(str1.charAt(i) == str2.charAt(j)){
                    deleted += j;
                    deleted += i;
                    foundStart = true;
                    break;
                }
            }
            if(foundStart) {
                break;
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