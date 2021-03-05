import java.io.*;
import java.util.*;

public class EscapeRoom {
    static int m, n;
    static int[][] grid;
    static boolean[][] vis;
    static ArrayList<Pair>[] lookup;

    public static void main(String[] args) throws Exception {
        FastIO fi = new FastIO(System.in, System.out);
        m = fi.nextInt();
        n = fi.nextInt();
        grid = new int[m][n];
        vis = new boolean[m][n];
        lookup = new ArrayList[(int) 1e6 + 1];
        for (int i = 0; i < lookup.length; i++) {
            lookup[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = fi.nextInt();
                lookup[grid[i][j]].add(new Pair(i, j));
            }
        }
        dfs(m - 1, n - 1);
        if (canEscape) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    static boolean canEscape = false;

    static void dfs(int r, int c) {
        if (canEscape) return;
        vis[r][c] = true;
        if (r == 0 && c == 0) canEscape = true;
        for (Pair p : lookup[(r + 1) * (c + 1)]) {
            if (!vis[p.a][p.b]) {
                dfs(p.a, p.b);
            }
        }
    }

    static class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1<<16];
        private int curChar, numChars;

        // standard input
        public FastIO() { this(System.in,System.out); }
        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }
        // file input
        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }

        // throws InputMismatchException() if previously detected end of file
        private int nextByte() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1) return -1; // end of file
            }
            return buf[curChar++];
        }

        // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
        public String next() {
            int c; do { c = nextByte(); } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
            return res.toString();
        }
        public int nextInt() { // nextLong() would be implemented similarly
            int c; do { c = nextByte(); } while (c <= ' ');
            int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10*res+c-'0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}

