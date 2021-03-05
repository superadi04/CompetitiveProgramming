import java.io.*;
import java.util.StringTokenizer;

public class poker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("poker.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("poker.out")));
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long ans = arr[0] + arr[n - 1];
        for (int i = 0; i < n - 1; i++) {
            ans += Math.abs(arr[i + 1] - arr[i]);
        }
        out.println(ans / 2);
        out.close();
        br.close();
    }
}
