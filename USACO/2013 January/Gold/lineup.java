import java.io.*;
import java.util.*;

public class lineup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cows = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = Integer.parseInt(st.nextToken());
        }
        multiset<Integer> set = new multiset<>();
        int ans = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && set.size() <= k + 1) {
                set.add(cows[j]);
                ans = Math.max(ans, set.get(cows[j++]));
            }
            set.remove1(cows[i]);
        }
        out.println(ans);
        out.close();
        br.close();
    }

    public static class multiset<K> extends TreeMap<K,Integer> {
        public void add(K x) {
            if (this.containsKey(x)) {
                this.put(x,this.get(x)+1);
            }
            else {
                this.put(x,1);
            }
        }
        public void remove1 (K x) {
            if (!this.containsKey(x)) return;
            this.put(x,this.get(x)-1);
            if (this.get(x) == 0) {
                this.remove(x);
            }
        }
    }
}
