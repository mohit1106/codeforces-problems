import java.io.*;
import java.util.*;

public class G_White_Black_Balanced_Subtrees {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    static ArrayList<Integer>[] child;
    static int[] val;
    static int ans;

    // public static class Node{
    //     int data;
    //     Node left; 
    //     Node right;

    //     Node(int data) {
    //         this.data = data;
    //         this.left = null;
    //         this.right = null;
    //     }
    // }

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] par = new int[n+1];
        for (int i = 2; i <= n; i++) {
            par[i] = in.nextInt();
        }
        String str = in.next();

        child = new ArrayList[n+1];
        for(int i=1; i<=n; i++) child[i] = new ArrayList<>();
        for(int i=2; i <=n; i++){
            child[par[i]].add(i);
        }
        
        val = new int[n+1];
        for(int i=1; i<=n; i++){
            char c = str.charAt(i-1);
            val[i] = (c == 'W' ? 1 : -1);
        }
                ans = 0;

        dfs(1);
        System.out.println(ans);
    }

    public static int dfs(int u){
        int sum = val[u];
        for(int v : child[u]){
            sum += dfs(v);
        }
        if(sum == 0) ans++;
        return sum;
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