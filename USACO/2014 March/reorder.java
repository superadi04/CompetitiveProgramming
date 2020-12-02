import java.io.*;
import java.util.*;

public class reorder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reorder.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reorder.out")));
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] bpos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            b[i] = Integer.parseInt(st.nextToken());
            bpos[b[i]] = i;
        }
        int ans = 0;
        int max = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            int index = i;
            int count = 0;
            boolean test = false;
            while (!vis[index] && a[index] != b[index]) {
                vis[index] = true;
                count++;
                index = bpos[a[index]];
                test = true;
            }
            max = Math.max(max, count);
            if (test) ans++;
        }
        if (ans == 0) max = -1;
        out.print(ans + " " + max);
        out.close();
        br.close();
    }
}
