import java.io.*;
import java.util.*;

public class convention {
    static int n, m, c;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("convention.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        out.print(search());
        out.close();
        br.close();
    }

    static int search() {
        int lo = 0, hi = (int) 1E9;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (check(mid)) hi = mid; else lo = mid + 1;
        }
        return lo;
    }

    static boolean check(int x) {
        int buses = 1;
        int a = 0, b = 0;
        int count = 0;
        while (b < n) {
            if (count == c || arr[b] - arr[a] > x) {
                a = b;
                count = 0;
                ++buses;
            }
            ++b;
            ++count;
        }
        return buses <= m;
    }
}
