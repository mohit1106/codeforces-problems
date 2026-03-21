import java.io.*;
import java.util.*;

public class C_Puddles {

    static FastScanner in = new FastScanner(System.in);
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        solve();
    }

    static void solve() throws Exception {
        int h = in.nextInt();
        int w = in.nextInt();

        char[][] mat = new char[h][w];
        for (int i = 0; i < h; i++) {
            mat[i] = in.next().toCharArray();
        }

        boolean[][] vis = new boolean[h][w];
        int[] dx = {1, -1, 0 , 0};
        int[] dy  = {0, 0, 1, -1};

        int ans=0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                
                if(mat[i][j] == '.' && !vis[i][j]) {
                    boolean touchesborder=false;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        int x = curr[0], y = curr[1];
                        if(x==0 || x==h-1 || y==0 || y==w-1){
                            touchesborder = true;
                        }
                        for(int k=0; k<dx.length; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx>=0 && nx<h && ny>=0 && ny<w){
                                if(mat[nx][ny] =='.' && !vis[nx][ny]){
                                    vis[nx][ny] = true;
                                    q.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    if(!touchesborder) ans++;
                }
            }
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