import java.io.*;
import java.util.*;

public class records {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("records.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("records.out")));
        int n = Integer.parseInt(st.nextToken());
        multiset<TreeSet<String>> set = new multiset<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            TreeSet<String> r = new TreeSet<String>();
            for (int j = 0; j < 3; j++) {
                r.add(st.nextToken());
            }
            set.add(r);
        }
        int max = 0;
        for (Map.Entry<TreeSet<String>, Integer> entry : set.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        out.print(max);
        out.close();
        br.close();
    }

    public static class multiset<K> extends HashMap<K,Integer> {
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
