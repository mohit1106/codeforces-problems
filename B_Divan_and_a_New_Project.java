import java.io.*;
import java.util.*;

public class B_Divan_and_a_New_Project {

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
        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }

        int[][] arrcp = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            arrcp[i][0] = i;
            arrcp[i][1] = arr[i];
        }

        Arrays.sort(arrcp, 1, n+1, (a, b) -> Integer.compare(b[1], a[1]));

        int[] res = new int[n+1];
        res[0] = 0;

        int pos = 1, neg = -1;
        boolean posb = true;

        long minute = 0;

        for (int i = 1; i <= n; i++) {
            int idx = arrcp[i][0];

            res[idx] = posb ? pos++ : neg--;
            posb = !posb;

            minute += (long) arr[idx] * 2 * Math.abs(res[idx]);
        }

        System.out.println(minute);

        System.out.print(0 + " ");
        for (int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
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