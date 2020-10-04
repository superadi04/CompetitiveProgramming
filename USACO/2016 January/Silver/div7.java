import java.io.*;
import java.util.*;

public class div7 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("div7.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        int n = Integer.parseInt(st.nextToken());
        long[] sum = new long[n + 1];
        long[] mod = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            sum[i] += sum[i - 1] + Long.parseLong(st.nextToken());
            mod[i] = sum[i] % 7;
        }
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            if (!map.containsKey(mod[i])) {
                map.put(mod[i], i);
            } else {
                ans = Math.max(ans, i - map.get(mod[i]));
            }
        }
        out.print(ans);
        out.close();
        br.close();
    }
}
