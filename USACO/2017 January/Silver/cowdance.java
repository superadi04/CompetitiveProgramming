import java.util.*;
import java.io.*;

public class cowdance {
    static int[] arr;
    static TreeMap<Integer, Integer> multiset;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        out.print(search(t));
        out.close();
        br.close();
    }

    static int search(int t) {
        int lo = 0, hi = t;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (check(mid, t)) hi = mid; else lo = mid + 1;
        }
        return lo;
    }

    static boolean check(int k, int t) {
        multiset = new TreeMap<Integer, Integer>();
        int c = 0;
        int ans = 0;
        while (c < k && c < arr.length) {
            add(arr[c]);
            ++c;
        }
        for (int i = c; i < arr.length; i++) {
            ans = multiset.firstKey();
            remove(multiset.firstKey());
            add(arr[i] + ans);
        }
        return ans + (multiset.lastKey() - ans) <= t;
    }

    static void add(int n) {
        if (multiset.containsKey(n)) {
            multiset.put(n, multiset.get(n) + 1);
        } else {
            multiset.put(n, 1);
        }
    }

    static void remove(int n) {
        multiset.put(n, multiset.get(n) - 1);
        if (multiset.get(n) == 0) {
            multiset.remove(n);
        }
    }
}
