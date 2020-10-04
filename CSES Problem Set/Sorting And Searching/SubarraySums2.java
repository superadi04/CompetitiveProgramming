import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SubarraySums2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] += arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        Map<Long, Long> map = new HashMap<Long, Long>();
        long ans = 0;
        for (int i = 0; i < n + 1; i++) {
            if (map.containsKey(arr[i] - x)) {
                ans += map.get(arr[i] - x);
            }
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1L);
            }
        }
        System.out.print(ans);
        br.close();
    }
}
