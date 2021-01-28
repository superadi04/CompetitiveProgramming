import java.io.*;
import java.util.*;

public class BooksExchange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < q; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] seq = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                seq[j] = Integer.parseInt(st.nextToken()) - 1;
            }
            boolean[] vis = new boolean[n];
            int[] ans = new int[n];
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> cycle = new ArrayList<>();
                int index = j;
                while (!vis[index]) {
                    cycle.add(index);
                    vis[index] = true;
                    index = seq[index];
                }
                for (int k : cycle) {
                    ans[k] = cycle.size();
                }
            }
            for (int j : ans) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        br.close();
    }
}
