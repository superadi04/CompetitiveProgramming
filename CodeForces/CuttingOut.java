import java.io.*;
import java.util.*;

public class CuttingOut {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int lo = 0, hi = (int) 1E9;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            ArrayList<Integer> a = check(mid);
            if (a == null) {
                hi = mid - 1;
            } else {
                lo = mid;
                ans = a;
            }
        }
        for (int i : ans) {
            System.out.print(i + " ");
        }

    }

    static ArrayList<Integer> check(int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (i >= map.size() || ans.size() >= k) break;
            int currCount = entry.getValue();
            while (ans.size() < k && currCount >= x) {
                currCount -= x;
                ans.add(entry.getKey());
            }
            i++;
        }
        return (i >= map.size() && ans.size() < k) ? null : ans;
    }
}
