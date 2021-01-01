import java.io.*;
import java.util.*;

public class PlusFromPicture {
    static int h, w;
    static char[][] grid;
    static boolean[][] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        grid = new char[h][w];
        vis = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        boolean test = false;
        // Check if there is a cross shape at all
        outer: for (int i = 1; i < h - 1; i++) {
            for (int j = 1; j < w - 1; j++) {
                if (grid[i][j] =='*' && grid[i + 1][j] == '*' && grid[i - 1][j] == '*' && grid[i][j + 1] == '*' && grid[i][j - 1] == '*') {
                    test = true;
                    fill(i, j);
                    break outer;
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!vis[i][j] && grid[i][j] == '*') {
                    test = false;
                    break;
                }
            }
        }
        System.out.println(test ? "YES" : "NO");
    }

    static void fill(int r, int c) {
        int a = r;
        int b = c;
        while (a < h && grid[a][b] == '*') {
            vis[a][b] = true;
            a++;
        }
        a = r;
        b = c;
        while (a >= 0 && grid[a][b] == '*') {
            vis[a][b] = true;
            a--;
        }
        a = r;
        b = c;
        while (b < w && grid[a][b] == '*') {
            vis[a][b] = true;
            b++;
        }
        a = r;
        b = c;
        while (b >= 0 && grid[a][b] == '*') {
            vis[a][b] = true;
            b--;
        }
    }
}
