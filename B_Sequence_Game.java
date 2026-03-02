import java.io.*;
import java.util.*;

public class B_Sequence_Game {

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
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = in.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        list.add(seq[0]);
        for (int i = 1; i < n; i++) {
            if(list.get(list.size() - 1) > seq[i]) {
                list.add(seq[i]);
            }
            list.add(seq[i]);
        }
        int m = list.size();
        System.out.println(m);
        for (int i = 0; i < m; i++) {
            System.out.print(list.get(i) + " ");
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