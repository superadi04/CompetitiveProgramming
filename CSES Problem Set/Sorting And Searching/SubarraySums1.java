import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubarraySums1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int count = 0;
        int a = 0;
        int b = 0;
        long sum = arr[0];
        while (a < n) {
            if (sum == x) {
                ++count;
            }
            if (b < n - 1 && (b == a || arr[b + 1] + sum <= x)) {
                ++b;
                sum += arr[b];
            } else {
                ++a;
                sum -= arr[a - 1];
            }
        }
        System.out.print(count);
    }
}
