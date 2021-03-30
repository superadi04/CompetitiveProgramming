import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JustGreenEnough {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][n];
        int[][] countsWith100 = new int[n][n];
        int[][] countsWithout100 = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            int count2 = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] >= 100) {
                    count++;
                } else {
                    count = 0;
                }
                countsWith100[i][j] = count;
                if (grid[i][j] > 100) {
                    count2++;
                } else {
                    count2 = 0;
                }
                countsWithout100[i][j] = count2;
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min1 = Integer.MAX_VALUE;
                int min2 = Integer.MAX_VALUE;
                long ans1 = 0;
                long ans2 = 0;
                for (int k = j; k < n; k++) {
                    min1 = Math.min(min1, countsWith100[k][i]);
                    min2 = Math.min(min2, countsWithout100[k][i]);
                    ans1 += min1; ans2 += min2;
                }
                ans += ans1 - ans2;
            }
        }
        System.out.println(ans);
    }
}
