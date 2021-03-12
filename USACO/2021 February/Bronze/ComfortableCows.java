import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ComfortableCows {
    static boolean[][] grid = new boolean[1005][1005];
    static boolean[][] isAdjacent = new boolean[1005][1005];
    static int comfortable = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] xs = new int[n];
        int[] ys = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 2;
            int y = Integer.parseInt(st.nextToken()) + 2;
            xs[i] = x;
            ys[i] = y;
            grid[x][y] = true;
        }

        // Check how many cows are comfortable
        for (int i = 0; i < 1005; i++) {
            for (int j = 0; j < 1005; j++) {
                if (grid[i][j]) {
                    if (checkAdjacent(i, j)) {
                        comfortable++;
                        isAdjacent[i][j] = true;
                    }
                }
            }
        }

        int[] ans = new int[n];
        ans[n - 1] = comfortable;

        for (int i = n - 1; i > 0; i--) {
            grid[xs[i]][ys[i]] = false;
            add(xs[i] + 1, ys[i]);
            add(xs[i] - 1, ys[i]);
            add(xs[i], ys[i] + 1);
            add(xs[i], ys[i] - 1);
            ans[i - 1] = comfortable;
        }

        for (int i : ans) {
            System.out.println(i);
        }
    }

    public static void add(int i, int j) {
        if (grid[i][j]) {
            if (checkAdjacent(i, j) && !isAdjacent[i][j]) {
                comfortable++;
                isAdjacent[i][j] = true;
            } else if (!checkAdjacent(i, j) && isAdjacent[i][j]) {
                comfortable--;
                isAdjacent[i][j] = false;
            }
        }
    }

    public static boolean checkAdjacent(int i, int j) {
        int count = 0;
        if (grid[i + 1][j]) count++;
        if (grid[i - 1][j]) count++;
        if (grid[i][j + 1]) count++;
        if (grid[i][j - 1]) count++;
        return count == 3;
    }
}
