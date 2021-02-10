import java.io.*;
import java.util.*;

public class CandyBox {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                } else {
                    map.put(x, 1);
                }
            }

            TreeMap<Integer, Integer> valuecounts = new TreeMap<>(Collections.reverseOrder());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (valuecounts.containsKey(entry.getValue())) {
                    valuecounts.put(entry.getValue(), valuecounts.get(entry.getValue()) + 1);
                } else {
                    valuecounts.put(entry.getValue(), 1);
                }
            }

            int curr = Integer.MAX_VALUE;
            int ans = 0;
            for (Map.Entry<Integer, Integer> entry : valuecounts.entrySet()) {
                curr = Math.min(curr, entry.getKey());
                ans += Math.min(curr, entry.getValue()) * (curr + Math.max(1, curr - entry.getValue() + 1)) / 2;
                curr -= Math.min(curr, entry.getValue());
                if (curr <= 0) break;
            }

            System.out.println(ans);
        }
    }
}
