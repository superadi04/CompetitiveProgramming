import java.io.*;
import java.util.*;

public class pairup {
    static TreeMap<Integer, Integer> multiset = new TreeMap<Integer, Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            multiset.put(y, x);
        }
        int a = multiset.firstKey();
        int b = multiset.lastKey();
        int max = 0;
        while (multiset.size() > 0) {
            a = multiset.firstKey();
            b = multiset.lastKey();
            max = Math.max(a + b, max);
            if (multiset.get(a) == multiset.get(b)) {
                multiset.remove(a);
                multiset.remove(b);
            } else if (multiset.get(a) < multiset.get(b)) {
                multiset.put(b, multiset.get(b) - multiset.get(a));
                multiset.remove(a);
            } else {
                multiset.put(a, multiset.get(a) - multiset.get(b));
                multiset.remove(b);
            }
        }
        out.print(max);
        out.close();
        br.close();
    }

    static void add(int x){
        if(multiset.containsKey(x)){
            multiset.put(x, multiset.get(x) + 1);
        } else {
            multiset.put(x, 1);
        }
    }
}
