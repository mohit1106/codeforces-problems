import java.io.*;
import java.util.*;

public class D_Minimize_Range {

    static FastScanner in = new FastScanner(System.in);
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        solve();
    }

    static void solve() throws Exception {
    int n = in.nextInt();
    long k = in.nextLong();

    long[] a = new long[n];
    for (int i = 0; i < n; i++) {
        a[i] = in.nextLong() % k;
    }

    Arrays.sort(a);
    long ans = a[n - 1] - a[0]; 
    for (int i = 0; i < n - 1; i++) {
        long high = a[i] + k;
        long low = a[i + 1];
        ans = Math.min(ans, high - low);
    }

    System.out.println(ans);
}

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = readByte();
            } while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long val = 0;
            do {
                c = readByte();
            } while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        String next() throws IOException {
            int c;
            StringBuilder sb = new StringBuilder();
            do {
                c = readByte();
            } while (c <= ' ');
            while (c > ' ') {
                sb.append((char) c);
                c = readByte();
            }
            return sb.toString();
        }
    }
}