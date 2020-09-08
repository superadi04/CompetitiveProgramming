import java.io.*;
import java.util.*;

public class diamond {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] diamonds = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            diamonds[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        Arrays.sort(diamonds);
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (diamonds[j] - diamonds[i] <= k) {
                    ++count;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        out.print(max);
        out.close();
        br.close();
    }
}
