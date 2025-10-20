import java.io.*;
import java.util.*;

public class C_Good_Array {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
        }
        
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0; i<n;i++){
            long newsum = sum-arr[i];
            if(newsum%2 != 0){
                continue;
            }

            long x =  (newsum/2);
            if (x<1 || x>1_000_000) continue;

            int cnt = freq.getOrDefault((int)x, 0);
            if(x == arr[i]){
                if(cnt>=2) res.add(i+1);
            } else{
                if(cnt>=1) res.add(i+1);
            }
        }
        System.out.println(res.size());
        for(int idx : res){
            System.out.print(idx + " ");
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