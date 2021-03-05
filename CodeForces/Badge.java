import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Badge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[n];
            int index = i;
            do {
                vis[index] = true;
                index = arr[index];
            } while (!vis[index]);
            ans[i] = index;
        }
        for (int i : ans) {
            System.out.print((i + 1) + " ");
        }
    }
}
