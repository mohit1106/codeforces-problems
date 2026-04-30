import java.io.*;
import java.util.*;

public class CSnowfall {

    static FastScanner in = new FastScanner(System.in);
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
        System.out.print(out.toString());
    }

    static void solve() throws Exception {
        int n = in.nextInt();
        List<Integer> d6 = new ArrayList<>();
        List<Integer> d2 = new ArrayList<>();
        List<Integer> d3 = new ArrayList<>();
        List<Integer> other = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x % 6 == 0) {
                d6.add(x);
            } else if (x % 2 == 0) {
                d2.add(x);
            } else if (x % 3 == 0) {
                d3.add(x);
            } else {
                other.add(x);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int x : d6) sb.append(x).append(" ");
        for (int x : d2) sb.append(x).append(" ");
        for (int x : other) sb.append(x).append(" ");
        for (int x : d3) sb.append(x).append(" ");

        System.out.println(sb.toString());
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