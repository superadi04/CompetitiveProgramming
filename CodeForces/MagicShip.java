import java.io.*;
import java.util.*;

public class MagicShip {
    static long x1, y1, x2, y2;
    static String s;
    static int n;
    static long[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x1 = Long.parseLong(st.nextToken());
        y1 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x2 = Long.parseLong(st.nextToken());
        y2 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new long[n + 1][2];
        st = new StringTokenizer(br.readLine());
        s = st.nextToken();

        for (int i = 1; i < n + 1; i++) {
            char c = s.charAt(i - 1);
            if (c == 'U') {
                arr[i][0] += arr[i - 1][0] + 1;
                arr[i][1] += arr[i - 1][1];
            } else if (c == 'D') {
                arr[i][0] += arr[i - 1][0] - 1;
                arr[i][1] += arr[i - 1][1];
            } else if (c == 'L') {
                arr[i][1] += arr[i - 1][1] - 1;
                arr[i][0] += arr[i - 1][0];
            } else {
                arr[i][1] += arr[i - 1][1] + 1;
                arr[i][0] += arr[i - 1][0];
            }
        }
        System.out.println(search());
    }

    static long search() {
        long lo = 0, hi = (long) 1E18;
        long res = -1;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (!check(mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
                res = mid;
            }
        }
        return res;
    }

    static boolean check(long x) {
        long a =  x % n;
        long b =  x / n;
        long x3 = (arr[(int) a][1] + arr[n][1] * b) + x1;
        long y3 = (arr[(int) a][0] + arr[n][0] * b) + y1;
        long ans = Math.abs(x2 - x3) + Math.abs(y2 - y3);
        return ans <= x;
    }
}
