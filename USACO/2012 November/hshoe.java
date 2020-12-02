import java.io.*;
import java.util.*;

public class hshoe {
    static ArrayList<String> parantheses = new ArrayList<>();
    static int n;
    static char[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hshoe.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hshoe.out")));
        n = Integer.parseInt(st.nextToken());
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        floodfill(0, 0, "", new boolean[n][n]);
        int ans = 0;
        for (String s : parantheses) {
            if (checkBalanced(s)) {
                ans = Math.max(ans, s.length());
            }
        }
        out.print(ans);
        out.close();
        br.close();
    }

    static boolean checkBalanced(String s) {
        if (s.length() % 2 == 1) return false;
        int open = 0;
        int closed = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == '(') open++;
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (s.charAt(i) == ')') closed++;
        }
        return open == s.length() / 2 && closed == s.length() / 2;
    }

    static void floodfill(int r, int c, String s, boolean[][] vis) {
        if(r < 0 || r >= n || c < 0 || c >= n) return;
        if(vis[r][c]) return;
        vis[r][c] = true;
        s += Character.toString(grid[r][c]);
        parantheses.add(s);
        floodfill(r, c+1, s, makeCopy(vis));
        floodfill(r+1, c, s, makeCopy(vis));
        floodfill(r, c-1, s, makeCopy(vis));
        floodfill(r-1, c, s, makeCopy(vis));
    }

    // Java is so bad
    static boolean[][] makeCopy(boolean[][] orig) {
        boolean[][] copy = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = orig[i][j];
            }
        }
        return copy;
    }
}
