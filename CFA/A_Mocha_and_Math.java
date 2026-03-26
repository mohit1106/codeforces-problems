import java.io.*;
import java.util.*;

public class A_Mocha_and_Math {
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
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        if(n==1) {
            System.out.println(arr[0]);
        }
        else if(n == 2){
            System.out.println(arr[0] & arr[1]);
        } else{
        int min = arr[0];
        for(int i=1; i<n; i++){
            min = min & arr[i];
        }
        System.out.println(min);
    }
    }
    // static void mergeSort(int[] arr, int l, int r){
    //     while(l<r){
    //         int m =  l + (r-l)/2;
    //         mergeSort(arr, l, m);
    //     mergeSort(arr, m+1, r);
    //     merge(arr, l, m, r);
    //     }
    // }
    // static void merge(int[] arr, int l, int m, int r){
    //     int[] temp = new int[r-l+1];
    //     int i= l;
    //     int j = m+1;
    //     int k= 0;
    //     while(i <= l && j <= r){
    //         temp[k++] = arr[i] > arr[j] ? arr[i] : arr[j];
    //     }
    //     while(i<=l) temp[k++] = arr[i++];
    //     while(j<=r) temp[k++] = arr[j++];

    //     for( i=l, k=0; i<=r; i++, k++){
    //         arr[i] = temp[k];
    //     }
    // }

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