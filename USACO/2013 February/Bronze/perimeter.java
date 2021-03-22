import java.io.*;
import java.util.StringTokenizer;

public class perimeter {
    static int n;
    static boolean[][] haybales;
    static int startx = 100;
    static int starty = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        haybales = new boolean[100][100];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            haybales[x][y] = true;
            startx = x;
            starty = y;
        }
        vis = new boolean[100][100];
        int ans = ff(startx, starty, true);
        check = false;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (!vis[i][j]) {
                    int add = ff(i, j, false);
                    if (!check) ans -= add;
                    check = false;
                }
            }
        }
        out.println(ans);
        out.close();
        br.close();
    }

    static boolean[][] vis;
    static boolean check = false;

    static int ff(int r, int c, boolean lookingForHaybales) {
        if (r >= 100 || r < 0 || c >= 100 || c < 0) {
            check = true;
            return 0;
        }
        if (vis[r][c]) return 0;
        if ((!haybales[r][c] && lookingForHaybales) || (haybales[r][c] && !lookingForHaybales)) return 0;
        vis[r][c] = true;
        return calculatePerimeter(r, c, lookingForHaybales) + ff(r + 1, c, lookingForHaybales) + ff(r - 1, c, lookingForHaybales) + ff(r, c + 1, lookingForHaybales) + ff(r, c - 1, lookingForHaybales);
    }

    static int calculatePerimeter(int r, int c, boolean lookingForHaybales) {
        int count = 0;
        if (r + 1 >= 100 || ((!haybales[r + 1][c] && lookingForHaybales) || (haybales[r + 1][c] && !lookingForHaybales))) count++;
        if (r - 1 < 0 || ((!haybales[r - 1][c] && lookingForHaybales) || (haybales[r - 1][c] && !lookingForHaybales))) count++;
        if (c + 1 >= 100 || ((!haybales[r][c + 1] && lookingForHaybales) || (haybales[r][c + 1] && !lookingForHaybales))) count++;
        if (c - 1 < 0 || ((!haybales[r][c - 1] && lookingForHaybales) || (haybales[r][c - 1] && !lookingForHaybales))) count++;
        return count;
    }
}
