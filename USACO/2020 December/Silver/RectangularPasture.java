import java.io.*;
import java.util.*;

public class RectangularPasture {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        int[] y = new int[n];
        TreeSet<Integer> xset = new TreeSet<>();
        TreeSet<Integer> yset = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            xset.add(x[i]);
            yset.add(y[i]);
        }
        HashMap<Integer, Integer> xcompress = new HashMap<>();
        HashMap<Integer, Integer> ycompress = new HashMap<>();
        int count = 0;
        for (int i : xset) {
            if (!xcompress.containsKey(i)) xcompress.put(i, ++count);
        }
        count = 0;
        for (int i : yset) {
            if (!ycompress.containsKey(i)) ycompress.put(i, ++count);
        }
        int[][] pref = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            x[i] = xcompress.get(x[i]);
            y[i] = ycompress.get(y[i]);
            pref[x[i]][y[i]]++;
        }
        // Construct prefix sum array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = pref[i][j] + pref[i-1][j] + pref[i][j-1] - pref[i-1][j-1];
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long upper = pref[Math.max(x[i], x[j])][n]
                        - pref[Math.min(x[i], x[j]) - 1][n]
                        - pref[Math.max(x[i], x[j])][Math.max(y[i], y[j]) - 1]
                        + pref[Math.min(x[i], x[j]) - 1][Math.max(y[i], y[j]) - 1];
                long lower = pref[Math.max(x[i], x[j])][Math.min(y[i], y[j])]
                        - pref[Math.min(x[i], x[j]) - 1][Math.min(y[i], y[j])]
                        - pref[Math.max(x[i], x[j])][0]
                        + pref[Math.min(x[i], x[j]) - 1][0];
                ans += (lower * upper);
            }
        }
        System.out.println(ans + 1);
    }
}
