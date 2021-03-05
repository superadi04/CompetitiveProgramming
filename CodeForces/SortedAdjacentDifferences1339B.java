import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortedAdjacentDifferences1339B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int mid = n / 2;
            int lo = mid - 1, hi = mid + 1;
            System.out.print(arr[mid] + " ");
            while (hi < n || lo >= 0) {
                if (lo >= 0) System.out.print(arr[lo] + " ");
                if (hi < n) System.out.print(arr[hi] + " ");
                hi++; lo--;
            }
        }
    }
}
