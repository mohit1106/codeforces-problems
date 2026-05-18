import java.io.*;
import java.util.*;

public class ChalkboardMedian {

    static FastScanner in = new FastScanner(System.in);
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        solve();
    }

    static void solve() throws Exception {
        int x = in.nextInt();
        int q = in.nextInt();
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); //maxheap stores smaller values
        PriorityQueue<Integer> right = new PriorityQueue<>(); //min heap - stores larger vlaues

        add(x, left, right);

        while (q-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, left, right);
            add(b, left, right);
            System.out.println(left.peek());
        }
    }

    static void add(int val, PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.isEmpty() || val <= left.peek()) {
            left.add(val);
        } else {
            right.add(val);
        }
        if (left.size() < right.size()) {
            left.add(right.poll());
        }

        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        }
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