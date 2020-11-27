import java.util.*;
import java.io.*;

public class sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sort.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
        int n = Integer.parseInt(st.nextToken());
        int[] notsorted = new int[n];
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            notsorted[i] = j;
            sorted[i] = j;
        }
        Arrays.sort(sorted);
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(notsorted[i])) {
                map.get(notsorted[i]).add(i);
            } else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                map.put(notsorted[i], set);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (map.get(sorted[i]).first() > i) {
                ans = Math.max(ans, map.get(sorted[i]).first() - i);
                map.get(sorted[i]).remove(map.get(sorted[i]).first());
            }
        }
        out.print(ans + 1);
        out.close();
        br.close();
    }
}
