import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Vacations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] days = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n + 1][2];
        // 0 if he is resting
        // 1 is he is writing contest
        // 2 if he is doing sport
        // -1 arbitrary
        for (int i = 1; i <= n; i++) {
            if (days[i - 1] == 0) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = 0;
            } else if (days[i - 1] == 1 || days[i - 1] == -1) {
                if (dp[i - 1][1] != 1) {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = 1;
                } else {
                    dp[i][0] = dp[i - 1][0] + 1;
                    dp[i][1] = 0;
                }
            } else if (days[i - 1] == 2 || days[i - 1] == -1) {
                if (dp[i - 1][1] != 2) {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = 2;
                } else {
                    dp[i][0] = dp[i - 1][0] + 1;
                    dp[i][1] = 0;
                }
            } else {
                if (dp[i - 1][1] == 1) {
                    dp[i][1] = 2;
                } else if (dp[i - 1][1] == 2){
                    dp[i][1] = 1;
                } else {
                    dp[i][1] = -1;
                }
                dp[i][0] = dp[i - 1][0];
            }
        }
        System.out.println(dp[n][0]);
    }
}