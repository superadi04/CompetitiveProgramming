import java.io.*;
import java.util.*;

public class Books {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Long> list = new ArrayList<Long>();
        for (int i = 0; i < n; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }
        long sum = 0;
        int books = 0;
        int a = 0;
        int b = 0;
        while (a < n) {
            if (b < n && list.get(b) + sum <= t) {
                sum += list.get(b);
                ++b;
            } else {
                if (b - a > books) {
                    books = b - a;
                }
                sum -= list.get(a);
                if (sum < 0) {
                    sum = 0;
                }
                if (b < n - 1 && a == b) {
                    ++b;
                }
                ++a;
            }
        }
        System.out.print(books);
    }
}