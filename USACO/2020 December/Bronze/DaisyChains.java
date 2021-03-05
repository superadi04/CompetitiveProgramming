import java.io.*;
import java.util.*;

public class DaisyChains {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double avg = 0;
                HashSet<Double> set = new HashSet<Double>();
                for (int k = i; k <= j; k++) {
                    set.add(arr[k]);
                    avg += arr[k];
                }
                avg /= (j - i + 1);
                if (set.contains(avg)) {
                    ans++;
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(ans);
        out.close();
        br.close();
    }
}
