import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayDivision {
    static int[] arr;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long lo = 0, hi = (long) 1e18;
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(lo);
    }

    static boolean check(long max) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            while (i < n && sum + arr[i] <= max) {
                sum += arr[i++];
            }
            if (i < n && arr[i] > max) return false;
            if (i < n && sum + arr[i] > max && sum > 0) i--;
            count++;
        }
        return count <= k;
    }
}
