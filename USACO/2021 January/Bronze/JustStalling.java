import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JustStalling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] cows = new int[n];
        int[] stalls = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) cows[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) stalls[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(stalls);
        long ans = 1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j : cows) if (j <= stalls[i]) count++;
            ans *= (count - i);
        }
        System.out.println(ans);
    }
}
