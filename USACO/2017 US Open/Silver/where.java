import java.io.*;
import java.util.*;

public class where {
    static char[][] grid;
    static boolean[][] vis;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("where.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
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
                for (int k = i; k < n; k++) {
                    for (int l = j; l < n; l++) {
                        vis = new boolean[n][n];
                        int[] colors = new int[26];
                        for (int a = i; a <= k; a++) {
                            for (int b = j; b <= l; b++) {
                                if (!vis[a][b]) {
                                    ff(i, k, j, l, a, b, grid[a][b]);
                                    colors[grid[a][b]-65]++;
                                }
                            }
                        }
                        boolean onlyOneComponent = false, twoOrMore = false;
                        int numColors = 0;
                        for (int a : colors) {
                            if (a > 0) {
                                numColors++;
                                if (a == 1) {
                                    onlyOneComponent = true;
                                } else {
                                    twoOrMore = true;
                                }
                            }
                        }
                        if (numColors == 2 && onlyOneComponent && twoOrMore) {
                            Rectangle x = new Rectangle(i, k, j, l);
                            pcls.add(x);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < pcls.size(); i++) {
            if (isMaxPCL(i)) ans++;
        }
        out.println(ans);
        out.close();
        br.close();
    }

    static boolean isMaxPCL(int i) {
        for (int j = 0; j < pcls.size(); j++) {
            if (i != j && checkInside(pcls.get(i), pcls.get(j))) return false;
        }
        return true;
    }

    static boolean checkInside(Rectangle a, Rectangle b) {
        // Check if rectangle a is within rectangle b
        return (b.x1 <= a.x1 && b.x2 >= a.x2 && b.y1 <= a.y1 && b.y2 >= a.y2);
    }

    static void ff(int x1, int x2, int y1, int y2, int r, int c, char curr) {
        if (r < x1 || r > x2 || c < y1 || c > y2) return;
        if (grid[r][c] != curr) return;
        if (vis[r][c]) return;
        vis[r][c] = true;
        ff(x1, x2, y1, y2, r + 1, c, curr);
        ff(x1, x2, y1, y2,r - 1, c, curr);
        ff(x1, x2, y1, y2, r, c + 1, curr);
        ff(x1, x2, y1, y2, r, c - 1, curr);
    }

    static ArrayList<Rectangle> pcls = new ArrayList<>();

    static class Rectangle {
        int x1, x2, y1, y2;

        public Rectangle(int x1, int x2 ,int y1, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }
}
