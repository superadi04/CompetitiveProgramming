import java.io.*;
import java.util.*;

public class maxcross {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
        int n, k, b;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[n + 1];
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = true;
        }
        int[] pref = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            pref[i] = pref[i - 1] + (arr[i] ? 0 : 1);
        }
        int ans = 100000;
        int x = 1;
        int y = k;
        while (y < n) {
            ans = Math.min(ans, k - 1 - (pref[y] - pref[x]));
            ++x;
            ++y;
        }
        out.print(ans);
        out.close();
        br.close();
    }
}
