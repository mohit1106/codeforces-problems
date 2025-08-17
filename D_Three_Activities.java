import java.io.*;
import java.util.*;

public class D_Three_Activities {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        int n = in.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr3[i] = in.nextInt();
        }


        int[] idxOfBest3Arr1 = getTop3Indices(arr1);

        int[] idxOfBest3Arr2 = getTop3Indices(arr2);

        int[] idxOfBest3Arr3 = getTop3Indices(arr3);
        
        int res = 0;
        for(int x : idxOfBest3Arr1) {
            for (int y : idxOfBest3Arr2) {
                for (int z : idxOfBest3Arr3) {
                    if(x!=y && y!=z && x!= z){
                        res = Math.max(res, arr1[x]+arr2[y]+arr3[z]);
                    }
                }
            }
        }
        System.out.println(res);
    }

    public static int[] getTop3Indices (int[] arr) {
        int n = arr.length;
        int[] maxIdx = {-1,-1,-1};
        for (int i = 0; i < n; i++) {
            if(maxIdx[0]==-1 || arr[i] > arr[maxIdx[0]]){
                maxIdx[2] = maxIdx[1];
                maxIdx[1] = maxIdx[0];
                maxIdx[0] = i;
            } else if(maxIdx[1] == -1 || arr[i] > arr[maxIdx[1]]){
                maxIdx[2] = maxIdx[1];
                maxIdx[1] = i;
            } else if(maxIdx[2]== -1 || arr[i] > arr[maxIdx[2]]){
                maxIdx[2] = i;
            }
        }
        return maxIdx;
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