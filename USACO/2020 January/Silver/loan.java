import java.io.*;
import java.util.StringTokenizer;

public class loan {
    static long n, k, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("loan.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        long lo = 0, hi = (long) 1E12;
        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            if (check(mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        out.println(lo);
        out.close();
        br.close();
    }

    static boolean check(long x) {
        long days = 0;
        long gallons = 0;
        while (days < k && gallons < n) {
            long y = (n - gallons) / x;
            if (y < m) {
                days += (n - gallons) / m + (((n - gallons) % m != 0) ? 1 : 0);
                return days <= k;
            }
            long next = y * x;
            long daysInBlock = (n - gallons - next) / y + 1;
            days += daysInBlock;
            gallons += daysInBlock * y;
        }
        return days <= k && gallons >= n;
    }
}
