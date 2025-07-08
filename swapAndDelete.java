// https://codeforces.com/problemset/problem/1913/B

import java.io.*;
public class swapAndDelete {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            int n = s.length();
            int cnt0 = 0;
            int cnt1 = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') cnt0++;
                else cnt1++;
            }
            int available0 = cnt0;
            int available1 = cnt1;
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    if (available1 > 0) {
                        available1--;
                        k++;
                    } else {
                        break; 
                    }
                } else { 
                    if (available0 > 0) {
                        available0--;
                        k++;
                    } else {
                        break; 
                    }
                }
            }
            int cost = n - k; 
            System.out.println(cost);
        }
    }
}