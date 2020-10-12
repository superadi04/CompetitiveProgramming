import java.io.*;
import java.util.*;

public class homework {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("homework.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] pref = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            pref[i] += pref[i - 1] + arr[i - 1];
        }
        int[] min = new int[n];
        int minVal = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            minVal = Math.min(arr[i], minVal);
            min[i] = minVal;
        }
        double ans = 0;
        double[] max = new double[n - 2];
        for (int i = 1; i < n - 1; i++) {
            if ((pref[n] - pref[i] - min[i])/(n - i - 1.0) > ans) {
                ans = (pref[n] - pref[i] - min[i])/(n - i - 1.0);
            }
            max[i - 1] = (pref[n] - pref[i] - min[i])/(n - i - 1.0);
        }
        for (int i = 0; i < n - 2; i++) {
            if (max[i] == ans) out.println(i + 1);
        }
        out.close();
        br.close();
    }
}
