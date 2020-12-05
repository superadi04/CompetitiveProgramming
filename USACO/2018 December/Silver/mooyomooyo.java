import java.io.*;
import java.util.*;

public class mooyomooyo {
    static int[][] grid;
    static boolean[][] vis;
    static int n, k;
    static int currentSize = 0;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        grid = new int[n][10];
        vis = new boolean[n][10];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < 10; j++) {
                grid[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }
        boolean test;
        do {
            test = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    if (grid[i][j] != 0 && !vis[i][j]) {
                        floodfill(i, j, grid[i][j]);
                        if (currentSize >= k) {
                            applyZero();
                            test = true;
                        }
                        currentSize = 0;
                        vis = new boolean[n][10];
                    }
                }
            }
            gravity();
        } while (test);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                out.print(grid[i][j]);
            }
            out.println();
        }
        out.close();
        br.close();
    }

    static void floodfill(int r, int c, int color) {
        if (r < 0 || r >= n || c < 0 || c >= 10) return;
        if (grid[r][c] != color) return;
        if (vis[r][c]) return;
        vis[r][c] = true;
        currentSize++;
        floodfill(r, c+1, color);
        floodfill(r, c-1, color);
        floodfill(r-1, c, color);
        floodfill(r+1, c, color);
    }

    static void applyZero() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (vis[i][j]) {
                    grid[i][j] = 0;
                }
            }
        }
    }

    static void gravity() {
        for (int i = 0; i < 10; i++) {
            int lastNum = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[j][i] != 0) {
                    int num = grid[j][i];
                    grid[j][i] = 0;
                    grid[lastNum][i] = num;
                    lastNum--;
                }
            }
        }
    }
}
