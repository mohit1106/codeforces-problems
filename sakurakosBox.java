// https://codeforces.com/problemset/problem/2008/F

import java.io.*;
import java.util.*;
 
public class sakurakosBox {
    static final int MOD = 1_000_000_007;

    static long modPow(long base, long exp) {
        long res = 1;
        base %=MOD;
        while (exp >0) {
            if((exp & 1) == 1) res = (res * base) % MOD;
        base = (base * base) % MOD;
            exp >>=1;
        }
    return res;
    }

    static long modInv(long x) {
        return modPow(x, MOD - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter  pw = new PrintWriter(System.out);
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] arr = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            long[] prefix = new long[n];
            prefix[0] =arr[0] % MOD;
            for (int i =1; i <n; i++) {
            prefix[i]=(prefix[i-1] +arr[i])%MOD;
            }

            long productSum = 0;
            for (int i = 0; i < n - 1; i++) {
            long rightSum = (prefix[n - 1]-prefix[i] + MOD) % MOD;
                productSum = (productSum +arr[i] % MOD * rightSum) % MOD;
            }
            long Q =(long) n*(n -1) /2 %MOD;
            long Qinv = modInv(Q);

            long ans = productSum *Qinv% MOD;
            pw.println(ans);
        }
        pw.flush();
    }
}

