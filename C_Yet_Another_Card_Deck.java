import java.io.*;
import java.util.*;

public class C_Yet_Another_Card_Deck {

    static FastScanner in = new FastScanner(System.in);
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        // int t = in.nextInt();
        // while (t-- > 0) {
        //     solve();
        // }
        // System.out.print(out.toString());
        solve();
    }

    static void solve() throws Exception {
        int n = in.nextInt();
        int q = in.nextInt();

        int[] color = new int[n+1];
        for (int i = 1; i <= n; i++) {
            color[i] = in.nextInt();
        }

        int[] pos = new int[51];
        Arrays.fill(pos, -1);
        for (int i = 1; i <= n; i++) {
            if (pos[color[i]] == -1) {
                pos[color[i]] = i;
            }
        }

        for (int i = 1; i <= q; i++) {
            int t = in.nextInt();

            int currentPos = pos[t];
            System.out.print(currentPos + " ");

            for (int c = 1; c <= 50; c++) {
                if (pos[c] < currentPos) {
                    pos[c]++;
                }
            }
            pos[t] = 1;
        }

        System.out.println();
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