import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class wifi {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("wifi.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wifi.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        double[] cows = new double[n];
        for (int i = 0; i < n; i++) {
            cows[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cows);
        double[] dp = new double[n];
        dp[0] = a;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + Math.min(a, (cows[i] - cows[i - 1]) * b / 2);
        }
        if (dp[n - 1] == Math.floor(dp[n - 1]) && dp[n - 1] == Math.ceil(dp[n - 1])) {
            out.println((int) dp[n - 1]);
        } else {
            out.println(dp[n - 1]);
        }
        out.close();
        br.close();
    }
}
