import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class hayfeast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hayfeast.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hayfeast.out")));
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        Pair[] meals = new Pair[(int) n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meals[i] = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }
        multiset<Long> spices = new multiset<>();
        int j = 0;
        long ans = Long.MAX_VALUE;
        long currSum = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && currSum < m) {
                currSum += meals[j].f;
                spices.add(meals[j++].s);
            }
            if (currSum >= m) ans = Math.min(ans, spices.lastKey());
            currSum -= meals[i].f;
            spices.remove1(meals[i].s);
        }
        out.println(ans);
        out.close();
        br.close();
    }

    static class Pair {
        long f, s;

        public Pair(long f, long s) {
            this.f = f;
            this.s = s;
        }
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
