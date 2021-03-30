import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ComputerGame1183C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long q = Integer.parseInt(st.nextToken());
        for (long i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            long k = Integer.parseInt(st.nextToken());
            long n = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long lo = 0, hi = (long) 1e9;
            while (lo < hi) {
                long mid = (lo + hi + 1) / 2;
                if (mid <= n && check(k, n, a, b, mid)) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            if (check(k, n, a, b, 0)) {
                System.out.println(lo);
            } else {
                System.out.println(-1);
            }
        }
    }

    static boolean check(long k, long n, long a, long b, long firstTypeTurns) {
        k = k - (a * firstTypeTurns);
        if (k + a <= b && firstTypeTurns - 1 > n) return false;
        k = k - b * (n - firstTypeTurns);
        if (k <= 0) return false;
        return true;
    }
}
