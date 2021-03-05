import java.io.*;
import java.util.*;

public class photo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("photo.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] seq = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        int[] permutation = new int[n];
        Arrays.fill(permutation, Integer.MAX_VALUE);
        outer: for (int i = 1; i < seq[0]; i++) {
            HashSet<Integer> check = new HashSet<>();
            int[] ans = new int[n];
            ans[0] = i;
            ans[1] = seq[0] - i;
            check.add(ans[0]); check.add(ans[1]);
            for (int j = 2; j < n; j++) {
                ans[j] = seq[j - 1] - ans[j - 1];
                check.add(ans[j]);
            }
            if (check.size() < n) continue outer;
            for (int j = 0; j < n; j++) {
                if (ans[j] > permutation[j] || ans[j] <= 0) {
                    continue outer;
                }
            }
            permutation = ans;
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
        StringBuilder sb = new StringBuilder();
        for (int i : permutation) {
            sb.append(i + " ");
        }
        out.print(sb.toString().trim());
        out.close();
        br.close();
    }
}
