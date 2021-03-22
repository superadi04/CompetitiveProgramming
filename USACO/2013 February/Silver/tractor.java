import java.io.*;
import java.util.StringTokenizer;

public class tractor {
    static int[][] grid;
    static boolean[][] vis;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("tractor.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tractor.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        vis = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = 0, max = (int) 1E9;
        while (min < max) {
            int mid = (min + max) / 2;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!vis[i][j]) {
                        count = 0;
                        ffcheck(i, j, mid);
                    }
                }
            }
            if (test) {
                max = mid;
            } else {
                min = mid + 1;
            }
            vis = new boolean[n][n];
            test = false;
        }
        out.println(min);
        out.close();
        br.close();
    }

    static boolean test = false;
    static int count = 0;

    static void ffcheck(int r, int c, int d) {
        if (r < 0 || r >= n || c < 0 || c >= n) return;
        if (vis[r][c]) return;
        vis[r][c] = true;
        count++;
        if (count >= Math.ceil(n * n / 2.0)) {
            test = true;
            return;
        }
        if (r + 1 < n && Math.abs(grid[r + 1][c] - grid[r][c]) <= d) {
            ffcheck(r + 1, c, d);
        }
        if (r - 1 >= 0 && Math.abs(grid[r - 1][c] - grid[r][c]) <= d) {
            ffcheck(r - 1, c, d);
        }
        if (c + 1 < n && Math.abs(grid[r][c + 1] - grid[r][c]) <= d) {
            ffcheck(r, c + 1, d);
        }
        if (c - 1 >= 0 && Math.abs(grid[r][c - 1] - grid[r][c]) <= d) {
            ffcheck(r, c - 1, d);
        }

    }
}