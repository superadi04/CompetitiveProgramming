import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheMeetingPlaceCannotBeChanged {
    static double[] coordinates;
    static double[] speed;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        coordinates = new double[n];
        speed = new double[n];
        for (int i = 0; i < n; i++) {
            coordinates[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            speed[i] = Integer.parseInt(st.nextToken());
        }

        double lo = 0, hi = 2E9;
        while (lo < hi) {
            int mid = (int) (lo + hi) / 2;
            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        hi = lo;
        lo--;
        while (lo < hi) {
            double mid = (lo + hi + 1E-6) / 2;
            if (check(mid)) {
                hi = mid - 1E-6;
            } else {
                lo = mid;
            }
        }

        System.out.println(lo);
    }

    static boolean check(double n) {
        double right = Integer.MAX_VALUE;
        double left = 0;
        for (int i = 0; i < coordinates.length; i++) {
            left = Math.max(left, coordinates[i] - speed[i] * n);
            right = Math.min(right, coordinates[i] + speed[i] * n);
        }
        return left <= right;
    }
}
