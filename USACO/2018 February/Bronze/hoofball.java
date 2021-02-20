import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hoofball {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] cows = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cows);

        // See for each cow, the maximum range we can go
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[n];
            int j = i;
            int max = 0;
            int min = Integer.MAX_VALUE;
            while (!vis[j]) {
                max = Math.max(max, j);
                min = Math.min(min, j);
                vis[j] = true;
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if (j > 0) left = cows[j] - cows[j - 1];
                if (j < n - 1) right = cows[j + 1] - cows[j];
                if (left <= right) {
                    j--;
                } else {
                    j++;
                }
            }
            end[min] = Math.max(end[min], max);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        for (int i = 0; i < n; i++) {
            if (end[i] == 0) continue;
            for (int j = i + 1; j <= end[i]; j++) {
                ans[j] = Math.min(ans[j], Math.min((i != 0) ? ans[i - 1] : Integer.MAX_VALUE, ans[i]) + 1);
            }
            ans[0] = 1;
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
        out.println(ans[n - 1]);
        out.close();
        br.close();
    }
}
