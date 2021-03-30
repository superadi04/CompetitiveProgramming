import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SpacedOut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int columnSums = 0, rowSums = 0;
        for (int i=0; i<n; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < n-1; j+=2) {
                sum1 += grid[i][j];
                sum2 += grid[i][j+1];
            }
            if ((n & 1) == 1)  sum1 += grid[i][n-1];
            columnSums += Math.max(sum1, sum2);
        }
        for (int i = 0; i < n; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < n-1; j+=2) {
                sum1 += grid[j][i];
                sum2 += grid[j+1][i];
            }
            if ((n & 1) == 1)  sum1 += grid[n-1][i];
            rowSums += Math.max(sum1, sum2);
        }
        System.out.println(Math.max(columnSums, rowSums));
    }
}
