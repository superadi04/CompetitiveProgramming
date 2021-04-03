import java.io.*;
import java.util.*;

public class herding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("herding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int max = arr[n - 2] - arr[1] + Math.max(arr[1] - arr[0], arr[n - 1] - arr[n - 2]) - n + 2;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n - 1 && arr[j + 1] - arr[i] < n - j + i) j++;
            min = Math.min(min, n - j + i - 1);
        }
        out.println(Math.min(min,max)+"\n"+max);
        out.close();
    }
}
