import java.io.*;
import java.util.*;

public class baseball {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("baseball.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("baseball.out")));
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }
        Arrays.sort(arr);
        int count = 1;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int x = arr[i];
                int y = arr[j];
                ans += upperBound(y + (y - x) * 2) - lowerBound(y + (y - x));
            }
        }
        out.print(ans);
        out.close();
        br.close();
    }

    public static int upperBound(int a) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a < arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int lowerBound(int a) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a <= arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
