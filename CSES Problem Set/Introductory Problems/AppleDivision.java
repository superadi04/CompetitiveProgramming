import java.io.*;
import java.util.*;

public class AppleDivision {
    static ArrayList<Long> list = new ArrayList<Long>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }
        long ans = 1_000_000_000;
        for (int i = 0; i < 1 << n; i++) {
            long a = 0;
            long b = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    a += list.get(j);
                } else {
                    b += list.get(j);
                }
            }
            ans = Math.min(ans, Math.abs(a - b));
        }
        System.out.print(ans);
        br.close();
    }
}