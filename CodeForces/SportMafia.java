import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SportMafia {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // Sum of numbers from 1 to n:
        // n(n+1)/2
        long lo = 0, hi = (long) 1E9;
        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            long sum = mid * (mid + 1) / 2;
            if (sum - k + mid <= n) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(n - lo);
    }
}
