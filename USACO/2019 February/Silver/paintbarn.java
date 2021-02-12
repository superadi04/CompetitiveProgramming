import java.io.*;
import java.util.*;

public class paintbarn {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] grid = new int[1000][1000];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1, y1, x2, y2;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            for (int j = Math.min(x1, x2); j < Math.max(x1, x2); j++) {
                grid[y1][j]++;
                grid[y2][j]--;
            }
        }
        for (int i = 0; i < 999; i++) {
            for (int j = 0; j < 1000; j++) {
                grid[i + 1][j] += grid[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (grid[i][j] == k) {
                    ans++;
                }
            }
        }
        out.print(ans);
        out.close();
        br.close();
    }
}
