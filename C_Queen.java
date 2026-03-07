import java.io.*;
import java.util.*;

public class C_Queen {

    static FastScanner in = new FastScanner(System.in);
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        solve();
        System.out.print(out.toString());
    }

    static void solve() throws Exception {
        int n = in.nextInt();
        int[] par = new int[n+1];
        int[] c = new int[n+1];
        List<Integer>[] child = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            child[i] = new ArrayList<>();
        }
        
        int root = -1;
        for(int i=1; i<=n; i++) {
            par[i] = in.nextInt();
            c[i] = in.nextInt();
            
            if(par[i] == -1) root = i;
            else
                child[par[i]].add(i);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if(i == root) continue;
            
            if(c[i] == 1) {
                boolean okay = true;
                for(int ch : child[i]) {
                    if(c[ch] == 0) {
                        okay = false;
                        break;
                    }
                }
                if(okay) res.add(i);
            }
        }
        if(res.isEmpty()) 
            System.out.println(-1);
        else{
            for(int x : res) 
                System.out.print(x + " ");
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