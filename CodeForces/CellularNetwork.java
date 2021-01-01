import java.io.*;
import java.util.*;

public class CellularNetwork {
    static int[] cities;
    static TreeSet<Integer> towers = new TreeSet<>();
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cities = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            towers.add(Integer.parseInt(st.nextToken()));
        }
        int ans = 0;
        for (int i : cities) {
            if (i < towers.first()) {
                ans = Math.max(ans, towers.ceiling(i) - i);
            } else if (i > towers.last()) {
                ans = Math.max(ans, i - towers.floor(i));
            } else {
                ans = Math.max(ans, Math.min(towers.ceiling(i) - i, i - towers.floor(i)));
            }
        }
        System.out.println(ans);
    }
}
