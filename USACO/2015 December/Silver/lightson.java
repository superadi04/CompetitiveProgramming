import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lightson {
    static ArrayList<Pair>[][] switches;
    static boolean[][] grid;
    static boolean[][] vis;
    static int n;

    static int fincount = 1;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        switches = new ArrayList[n][n];
        grid = new boolean[n][n];
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switches[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            switches[x][y].add(new Pair(a, b));
        }
        grid[0][0] = true;
        while (true) {
            vis = new boolean[n][n];
            floodfill(0, 0);
            if (fincount == count) break;
            fincount = count;
            count = 0;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    ans++;
                }
            }
        }
        out.print(ans);
        out.close();
        br.close();
    }

    static void floodfill(int r, int c) {
        if(r < 0 || r >= n || c < 0 || c >= n) return;
        if(!grid[r][c]) return;
        if(vis[r][c]) return;
        vis[r][c] = true;
        count++;
        for (Pair p : switches[r][c]) grid[p.x][p.y] = true;
        floodfill(r, c+1);
        floodfill(r, c-1);
        floodfill(r-1, c);
        floodfill(r+1, c);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
