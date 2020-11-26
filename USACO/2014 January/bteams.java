import java.io.*;
import java.util.*;

public class bteams {
    static int[] arr = new int[12];
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("bteams.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bteams.out")));
        for (int i = 0; i < 12; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve(0);
        out.print(ans);
        out.close();
        br.close();
    }

    static int oneSum, twoSum, threeSum, fourSum;
    static int one, two, three, four;

    public static void solve(int n) {
        if (n == 12) {
            int min = Math.min(oneSum, Math.min(twoSum, Math.min(threeSum, fourSum)));
            int max = Math.max(oneSum, Math.max(twoSum, Math.max(threeSum, fourSum)));
            ans = Math.min(ans, max - min);
        } else {
            if (one < 3) {
                oneSum += arr[n];
                one++;
                solve(n + 1);
                oneSum -= arr[n];
                one--;
            }
            if (two < 3) {
                twoSum += arr[n];
                two++;
                solve(n + 1);
                twoSum -= arr[n];
                two--;
            }
            if (three < 3) {
                threeSum += arr[n];
                three++;
                solve(n + 1);
                threeSum -= arr[n];
                three--;
            }
            if (four < 3) {
                fourSum += arr[n];
                four++;
                solve(n + 1);
                fourSum -= arr[n];
                four--;
            }
        }
    }
}
