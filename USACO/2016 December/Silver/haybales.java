import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class haybales {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            out.println(upperBound(high) - lowerBound(low));
        }
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
