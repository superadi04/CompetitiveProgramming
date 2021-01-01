import java.io.*;
import java.util.*;

public class gates {
    static boolean[][] fence;
    static boolean[][] vis;
    static int n;

    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gates.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        fence = new boolean[n * 2][n * 2];
        vis = new boolean[n * 2][n * 2];
        String path = br.readLine();
        r = n;
        c = n;

        fence[r][c] = true;
        for (int i = 0; i < n; i++) {
            layFence(path, i);
            layFence(path, i);
        }

        int ans = -1;
        for (int i = 0; i < n * 2; i++) {
            for (int j = 0; j < n * 2; j++) {
                if (!vis[i][j] && !fence[i][j]) {
                    floodfill(i, j);
                    ans++;
                }
            }
        }
        out.print(ans);
        out.close();
        br.close();
    }

    static void layFence(String s, int i) {
        char a = s.charAt(i);
        if (a == 'N') {
            r++;
        } else if (a == 'S') {
            r--;
        } else if (a == 'E') {
            c++;
        } else {
            c--;
        }
        fence[r][c] = true;
    }

    static void floodfill(int r, int c) {
        if (r < 0 || r >= n * 2 || c < 0 || c >= n * 2) return;
        if (vis[r][c]) return;
        if (fence[r][c]) return;
        vis[r][c] = true;
        floodfill(r, c+1);
        floodfill(r, c-1);
        floodfill(r-1, c);
        floodfill(r+1, c);
    }
}
