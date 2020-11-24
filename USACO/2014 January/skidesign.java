import java.io.*;
import java.util.*;

public class skidesign {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())]++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 83; i++) {
            int tot = 0;
            for (int j = 0; j < i; j++) {
                tot += (i - j) * (i - j) * arr[j];
            }
            for (int j = i + 18; j < 101; j++) {
                tot += (j - i - 17) * (j - i - 17) * arr[j];
            }
            ans = Math.min(ans, tot);
        }
        out.print(ans);
        out.close();
        br.close();
    }
}
