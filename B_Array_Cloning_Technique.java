import java.io.*;
import java.util.*;

public class B_Array_Cloning_Technique {
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

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        int x = arr[0];
        for(Integer key : map.keySet()){
            Integer count = map.get(key);
            if(count > map.get(x)){
                x = key;
            }
        }

        int same = map.get(x);
        int diff = n-same;
        int ops = 0;

        while(same < n){
            ops++;
            if(same > diff) ops += diff;
            else ops += same;
            diff -= same;
            same = same*2;
        }
        System.out.println(ops);
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