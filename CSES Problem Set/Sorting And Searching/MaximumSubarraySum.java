import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MaximumSubarraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Long> list = new ArrayList<Long>();
        list.add(0L);
        long min = 0;
        long ans = Long.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            list.add(i, list.get(i - 1) + Long.parseLong(st.nextToken()));
            ans = Math.max(ans, list.get(i) - min);
            min = Math.min(min, list.get(i));
        }
        System.out.print(ans);
        br.close();
    }
}