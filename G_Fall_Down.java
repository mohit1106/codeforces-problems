import java.io.*;
import java.util.*;

public class G_Fall_Down {
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
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = in.next().toCharArray();
        }

        char[][] res= new char[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], '.');
        }

        for(int j=0; j<m; j++){
            int last = n-1;
            int stones = 0;

            for(int i=n-1; i>=0; i--){
                if(arr[i][j] == '*'){
                    stones++;
                } 
                else if(arr[i][j] == 'o'){
                    for (int k = 0; k < stones; k++) {
                        res[last--][j] = '*';
                    }
                    stones = 0;
                    res[i][j] = 'o';
                    last = i-1;
                } 
            }

            for (int k = 0; k < stones; k++) {
                res[last--][j] = '*';
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(new String(res[i]));
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