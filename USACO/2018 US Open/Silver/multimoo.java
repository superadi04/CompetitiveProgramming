import java.io.*;
import java.util.*;

public class multimoo {
    static int[][] grid;
    static int n;

    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
        FastIO fi = new FastIO("multimoo.in");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        n = fi.nextInt();
        grid = new int[n][n];
        coloredGrid = new int[n][n];
        visited = new boolean[n][n];

        // Input
        for (int i = 0; i < n; i++) {
            //st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = fi.nextInt();
            }
        }
        colorCounts = new int[n * n];
        coloredRegions = new int[n * n];

        int ans1 = 0;

        // Color each region
        int color = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    floodfill(i, j, color, grid[i][j]);
                    colorCounts[color] = currentSize;
                    coloredRegions[color] = grid[i][j];
                    ans1 = Math.max(ans1, currentSize);
                    currentSize = 0;
                    color++;
                }
            }
        }
        visited = new boolean[n][n];

        // Construct the Graph:

        // First we initialize the adjacency matrix
        adj = new HashSet[color];
        for (int i = 0; i < color; i++) {
            adj[i] = new HashSet<>();
        }

        // Then do floodfill again and construct the graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    floodfill2(i, j, coloredGrid[i][j]);
                }
            }
        }

        // Then we perform depth first search to determine largest region by 2 cows
        for (int i = 0; i < color; i++) {
            vis = new boolean[color];
            dfs(i);
        }
        out.println(ans1 + "\n" + ans2);
        out.close();
        //br.close();
    }


    static int[] coloredRegions;
    static boolean[] vis;
    static int count = 0;

    static int ans1 = 0;
    static int ans2 = 0;

    static void dfs(int node) {
        vis[node] = true;
        for (int i : adj[node]) {
            count = colorCounts[node] + colorCounts[i];
            dfs2(i, node, i);
            ans2 = Math.max(ans2, count);
        }
    }

    static void dfs2(int node, int srcNode1, int srcNode2) {
        if (vis[node]) return;
        vis[node] = true;
        for (int i : adj[node]) {
            if ((coloredRegions[i] == coloredRegions[srcNode1] || coloredRegions[i] == coloredRegions[srcNode2]) && !vis[i]) {
                count += colorCounts[i];
                dfs2(i, srcNode1, srcNode2);
            }
        }
    }

    static HashSet<Integer>[] adj;

    static void floodfill2(int r, int c, int color) {
        if(r < 0 || r >= n || c < 0 || c >= n) return;
        if (coloredGrid[r][c] != color) {
            add(color, coloredGrid[r][c]);
            return;
        }
        if(visited[r][c]) return;
        visited[r][c] = true;
        floodfill2(r, c+1, color);
        floodfill2(r, c-1, color);
        floodfill2(r-1, c, color);
        floodfill2(r+1, c, color);
    }

    static void add(int a, int b) {
        adj[a].add(b);
    }

    static int[] colorCounts; // Total area of region for each color

    static int currentSize = 0;
    static int[][] coloredGrid;
    static boolean[][] visited;

    static void floodfill(int r, int c, int color, int rep) {
        if(r < 0 || r >= n || c < 0 || c >= n) return;
        if(grid[r][c] != rep) return;
        if(visited[r][c]) return;
        visited[r][c] = true;
        coloredGrid[r][c] = color;
        currentSize++;
        floodfill(r, c+1, color, rep);
        floodfill(r, c-1, color, rep);
        floodfill(r-1, c, color, rep);
        floodfill(r+1, c, color, rep);
    }

    static class FastIO {

        InputStream dis;
        byte[] buffer = new byte[1 << 17];
        int pointer = 0;

        public FastIO(String fileName) throws Exception {
            dis = new FileInputStream(fileName);
        }

        public FastIO(InputStream is) throws Exception {
            dis = is;
        }

        int nextInt() throws Exception {
            int ret = 0;

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }

            return (negative) ? -ret : ret;
        }

        long nextLong() throws Exception {
            long ret = 0;

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }

            return (negative) ? -ret : ret;
        }

        byte nextByte() throws Exception {
            if (pointer == buffer.length) {
                dis.read(buffer, 0, buffer.length);
                pointer = 0;
            }
            return buffer[pointer++];
        }

        String next() throws Exception {
            StringBuffer ret = new StringBuffer();

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            while (b > ' ') {
                ret.appendCodePoint(b);
                b = nextByte();
            }

            return ret.toString();
        }

    }
}