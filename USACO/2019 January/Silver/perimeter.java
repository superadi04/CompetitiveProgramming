import java.io.*;
import java.util.*;

public class perimeter {
    static int n;
    static char[][] grid;
    static boolean[][] vis;

    static int perimeter = 0;
    static int area = 0;

    static int finperimeter = 0;
    static int finarea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '.' && !vis[i][j]) {
                    floodfill(i, j);
                    if (area > finarea) {
                        finarea = area;
                        finperimeter = perimeter;
                    } else if (area == finarea) {
                        finperimeter = Math.min(finperimeter, perimeter);
                    }
                }
                perimeter = 0;
                area = 0;
            }
        }
        out.print(finarea + " " + finperimeter);
        out.close();
        br.close();
    }

    static void floodfill(int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= n) return;
        if (vis[r][c]) return;
        if (grid[r][c] == '.') return;
        vis[r][c] = true;
        area++;
        perimeter += calculatePerimeter(r, c);
        floodfill(r, c+1);
        floodfill(r, c-1);
        floodfill(r-1, c);
        floodfill(r+1, c);
    }

    static int calculatePerimeter(int r, int c) {
        int p = 0;
        if (r - 1 < 0 || grid[r - 1][c] == '.') p++;
        if (r + 1 >= n || grid[r + 1][c] == '.') p++;
        if (c - 1 < 0 || grid[r][c - 1] == '.') p++;
        if (c + 1 >= n || grid[r][c + 1] == '.') p++;
        return p;
    }
}
