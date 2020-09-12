import java.io.*;
import java.util.*;

public class IncreasingArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long count = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                count += (arr[i - 1] - arr[i]);
                arr[i] = arr[i - 1];
            }
        }
        System.out.print(count);
    }
}