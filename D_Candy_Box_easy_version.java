import java.io.*;
import java.util.*;

public class D_Candy_Box_easy_version {
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
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        ArrayList<Integer> freq = new ArrayList<>(map.values());
        Collections.sort(freq, Collections.reverseOrder());

        int prev = freq.get(0);
        int ans = prev;
        for (int i = 1; i < freq.size(); i++) {
            prev = Math.min(prev - 1, freq.get(i));
            if (prev <= 0) break;
            ans += prev;
        }

        System.out.println(ans);
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