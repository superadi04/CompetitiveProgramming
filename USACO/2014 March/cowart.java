import java.io.*;
import java.util.*;

public class cowart {
    static int n;
    static char[][] grid;
    static boolean[][] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowart.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowart.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new char[n][n];
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int color = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    floodfill(i, j, grid[i][j]);
                    color++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'G') {
                    grid[i][j] = 'R';
                }
            }
        }
        vis = new boolean[n][n];
        int color2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    floodfill(i, j, grid[i][j]);
                    color2++;
                }
            }
        }
        out.print(color + " " + color2);
        out.close();
        br.close();
    }

    static void floodfill(int r, int c, char color) {
        if(r < 0 || r >= n || c < 0 || c >= n) return;
        if (grid[r][c] != color) return;
        if (vis[r][c]) return;
        vis[r][c] = true;

        floodfill(r, c+1, color);
        floodfill(r, c-1, color);
        floodfill(r-1, c, color);
        floodfill(r+1, c, color);
    }
}
