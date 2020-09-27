import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Towers {
    static TreeMap<Integer, Integer> multiset = new TreeMap<Integer,Integer>();
    static int towers = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            add(a);
            if (multiset.lastKey() == a) {
                ++towers;
            } else {
                remove(multiset.higherKey(a));
            }
        }
        System.out.print(towers);
        br.close();
    }

    static void add(int x) {
        if (multiset.containsKey(x)) {
            multiset.put(x, multiset.get(x) + 1);
        } else {
            multiset.put(x, 1);
        }
    }

    static void remove(int x) {
        multiset.put(x, multiset.get(x) - 1);
        if (multiset.get(x) == 0) {
            multiset.remove(x);
        }
    }
}
