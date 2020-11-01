import java.io.*;
import java.util.*;

public class MaximumMedian {
    static long[] arr;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.print(search());
        br.close();
    }

    public static long search() {
        long lo = 0, hi = (long) 2E9;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (check(mid)) lo = mid + 1; else hi = mid - 1;
        }
        return lo - 1;
    }

    public static boolean check(long x) {
        long operations = 0;
        for (int i = (arr.length - 1) / 2; i < arr.length; i++) {
            operations += Math.max(0, x - arr[i]);
        }
        return operations <= k;
    }

}
