import java.io.*;
import java.util.*;

public class A_Exciting_Bets {

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
        long a = in.nextLong();
        long b = in.nextLong();

        long diff =  Math.abs(a - b);
        // System.out.println(diff);
        long moves= 0;
        if (a== b) {
            System.out.println(0 + " " + 0);
            return;
        }
        if(a%diff == 0 && b%diff == 0) {
            System.out.println(diff + " " + 0);
            return;
        }
        long moves1 = diff - (a%diff);
        long moves2 = diff - (b%diff);

        moves = Math.min(a%diff, diff-(a%diff));

        System.out.println(diff + " " + moves);
    }
//     static int gcd(int a, int b) {
//     while (b != 0) {
//         int temp = a % b;
//         a = b;
//         b = temp;
//     }
//     return a;
// }

    public static int gcd(int a, int b){
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
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