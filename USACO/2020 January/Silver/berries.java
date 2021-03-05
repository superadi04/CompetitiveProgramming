import java.io.*;
import java.util.*;

public class berries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("berries.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        multiset<Integer> trees = new multiset<>();
        st = new StringTokenizer(br.readLine());
        int maxb = 0;
        for (int i = 0; i < n; i++) {
            int b = Integer.parseInt(st.nextToken());
            trees.add(b);
            maxb = Math.max(maxb, b);
        }
        int ans = 0;
        for (int i = 1; i <= maxb; i++) {
            multiset<Integer> tempBerries = (multiset<Integer>) trees.clone();
            int[] tempBaskets = new int[k];
            for (int j = 0; j < k; j++) {
                int b = tempBerries.lastKey();
                if (b <= i) {
                    tempBaskets[j] = b;
                    tempBerries.remove1(b);
                    tempBerries.add(0);
                } else {
                    tempBaskets[j] = i;
                    tempBerries.remove1(b);
                    tempBerries.add(b - i);
                }
            }
            Arrays.sort(tempBaskets);
            int count = 0;
            for (int j = 0; j < k / 2; j++) {
                count += tempBaskets[j];
            }
            ans = Math.max(ans, count);
        }
        out.println(ans);
        out.close();
        br.close();
    }

    public static class multiset<K> extends TreeMap<K,Integer>{
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
