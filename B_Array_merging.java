import java.io.*;
import java.util.*;

public class B_Array_merging {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        for (int i = 0; i < n; i++) b[i] = in.nextInt();

        Map<Integer, Integer> freqA = getFreqMap(a);
        Map<Integer, Integer> freqB = getFreqMap(b);

        int max = 0;
        for (int x : freqA.keySet()) {
            int combined = freqA.get(x) + freqB.getOrDefault(x, 0);
            max = Math.max(max, combined);
        }
        for (int x : freqB.keySet()) {
            if (!freqA.containsKey(x)) {
                max = Math.max(max, freqB.get(x));
            }
        }

        out.println(max);
    }

    static Map<Integer, Integer> getFreqMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        map.put(arr[0], 1);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) count++;
            else count = 1;
            map.put(arr[i], Math.max(map.getOrDefault(arr[i], 0), count));
        }
        return map;
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