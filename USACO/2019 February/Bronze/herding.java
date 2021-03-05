import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class herding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("herding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
        int max = 0;
        int min = 2;
        Arrays.sort(arr);
        for (int i = 0; i < 2; i++) {
            if (arr[i] + 1 != arr[i + 1]) {
                max = Math.max(max, arr[i + 1] - arr[i] - 1);
                min = Math.min(min, arr[i + 1] - arr[i] - 1);
            }
        }
        if (max == 0) min = 0;
        out.println(min + "\n" + max);
        out.close();
        br.close();
    }
}
