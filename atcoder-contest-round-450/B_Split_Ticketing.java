import java.io.*;
import java.util.*;

public class B_Split_Ticketing {

    static FastScanner in = new FastScanner(System.in);
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
            solve();
    }

    static void solve() throws Exception {
    int n = in.nextInt();
    long[][] c = new long[n+1][n+1];

    for (int i = 1; i <= n - 1; i++) {
        for (int j = i+1; j <= n; j++) {
            c[i][j] = in.nextLong();
        }
    }

    for (int a = 1; a <= n; a++) {
        for (int b = a+1; b <= n; b++) {
            for (int ccc = b+1; ccc <= n; ccc++) {
                if (c[a][b]+c[b][ccc] < c[a][ccc]) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
    }

    System.out.println("No");
}

    // -------- FAST IO --------
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