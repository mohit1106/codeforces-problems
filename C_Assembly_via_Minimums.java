import java.io.*;
import java.util.*;

public class C_Assembly_via_Minimums {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
    int n = in.nextInt();
    int m = n*(n-1)/2;
    Integer[] b = new Integer[m];
    for(int i=0;i<m;i++) b[i] = in.nextInt();
    
    TreeMap<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
    for(int x : b) map.put(x, map.getOrDefault(x,0)+1);

    int[] a = new int[n];
    int idx = 0;
while(idx < n){
    int val = map.firstKey(); 
    a[idx++] = val;

    map.put(val, map.get(val)-1);
    if(map.get(val) == 0) map.remove(val);

    for(int i=0;i<idx-1;i++){
        int minVal = Math.min(val, a[i]);
        map.put(minVal, map.get(minVal)-1);
        if(map.get(minVal) == 0) map.remove(minVal);
    }
}

    for(int i=0;i<n;i++) out.print(a[i]+" ");
    out.println();
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