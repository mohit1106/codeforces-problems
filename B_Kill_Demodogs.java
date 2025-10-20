import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class B_Kill_Demodogs {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static void solve() {
        long n = in.nextLong();
        long nMod = n % MOD;

        long n2 = mul(nMod, nMod);      
        long n3 = mul(n2, nMod);  

        long part1 = (4 * n3) % MOD;          
        long part2 = (3 * n2) % MOD;        
        long part3 = (MOD - nMod) % MOD; 

        long numer = (part1 + part2) % MOD;
        numer = (numer + part3) % MOD;       

        long inv6 = modPow(6, MOD - 2, MOD);
        long ansMod = mul(numer, inv6);      

        long res = mul(ansMod, 2022);       
        System.out.println(res);
        
    }
    public static long modPow(long a, long e, long mod){
        long res = 1;
        a %= mod;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            e >>= 1;
        }
        return res;
    }
    static long mul(long a, long b) {
        return (a % MOD) * (b % MOD) % MOD;
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