import java.io.*;
import java.util.*;

public class D_Matryoshkas {
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
        Map<Integer, Integer> freq = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
        }

        long sets = 0;
        int prev = -1;
        int prevFreq = 0;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();

            if(prev != val-1){
                sets += count;
            } else{
                if(count > prevFreq) sets += (count-prevFreq);
            }

            prev = val;
            prevFreq = count;
        }
        System.out.println(sets);
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