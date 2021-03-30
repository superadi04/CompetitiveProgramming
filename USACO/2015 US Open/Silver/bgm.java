import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bgm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("bgm.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bgm.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[][] dp = new long[7][7];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char letter = st.nextToken().charAt(0);
            int value = (Integer.parseInt(st.nextToken()) % 7 + 7) % 7;
            if (letter == 'B') {
                dp[0][value]++;
            } else if (letter == 'E') {
                dp[1][value]++;
            } else if (letter == 'S') {
                dp[2][value]++;
            } else if (letter == 'I') {
                dp[3][value]++;
            } else if (letter == 'G') {
                dp[4][value]++;
            } else if (letter == 'O') {
                dp[5][value]++;
            } else {
                dp[6][value]++;
            }
        }
        long ans = 0;
        for (int b = 0; b < 7; b++) {
            for (int e = 0; e < 7; e++) {
                for (int s = 0; s < 7; s++) {
                    for (int i = 0; i < 7; i++) {
                        for (int g = 0; g < 7; g++) {
                            for (int o = 0; o < 7; o++) {
                                for (int m = 0; m < 7; m++) {
                                    if ((b + e + s + s + i + e) * (g + o + e + s) * (m + o + o) % 7 == 0) {
                                        ans += dp[0][b] * dp[1][e] * dp[2][s] * dp[3][i] * dp[4][g] * dp[5][o] * dp[6][m];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        out.println(ans);
        out.close();
        br.close();
    }
}
