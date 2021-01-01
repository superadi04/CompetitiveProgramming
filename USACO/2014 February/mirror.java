import java.io.*;
import java.util.StringTokenizer;

public class mirror {
    static char[][] grid;
    static int ans = 0;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mirror.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mirror.out")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        // First row
        for (int i = 0; i < m; i++) {
            floodfill(0, i, 2);
            ans = Math.max(ans, currentSize);
            currentSize = 0;
        }

        // Last row
        for (int i = 0; i < m; i++) {
            floodfill(n - 1, i, 1);
            ans = Math.max(ans, currentSize);
            currentSize = 0;
        }

        // First column
        for (int i = 0; i < n; i++) {
            floodfill(i, 0, 4);
            ans = Math.max(ans, currentSize);
            currentSize = 0;
        }

        // Last column
        for (int i = 0; i < n; i++) {
            floodfill(i, m - 1, 3);
            ans = Math.max(ans, currentSize);
            currentSize = 0;
        }

        out.println(ans);
        out.close();
        br.close();
    }

    static int currentSize = 0;
    static boolean indef = false;

    static void floodfill(int r, int c, int dir) {
        if(r < 0 || r >= n || c < 0 || c >= m) return;
        currentSize++;
        if (dir == 1) {
            if (grid[r][c] == '/') {
                floodfill(r,c + 1, 4);
            } else {
                floodfill(r, c - 1, 3);
            }
        } else if (dir == 2) {
            if (grid[r][c] == '/') {
                floodfill(r, c - 1, 3);
            } else {
                floodfill(r, c + 1, 4);
            }
        } else if (dir == 3) {
            if (grid[r][c] == '/') {
                floodfill(r + 1, c , 2);
            } else {
                floodfill(r - 1, c, 1);
            }
        } else {
            if (grid[r][c] == '/') {
                floodfill(r - 1, c, 1);
            } else {
                floodfill(r + 1, c, 2);
            }
        }
    }

}
