import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class citystate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Pair[] arr  = new Pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken().substring(0, 2);
            String b = st.nextToken();
            arr[i] = new Pair(a, b);
        }
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        for (Pair p : arr) {
            if (!map.containsKey(p.a)) {
                HashMap<String, Integer> map2 = new HashMap<>();
                map2.put(p.b, 1);
                map.put(p.a, map2);
            } else {
                if (map.get(p.a).containsKey(p.b)) {
                    map.get(p.a).put(p.b, map.get(p.a).get(p.b) + 1);
                } else {
                    map.get(p.a).put(p.b, 1);
                }
            }
        }
        int ans = 0;
        for (Map.Entry<String, HashMap<String, Integer>> first : map.entrySet()) {
            for (Map.Entry<String, Integer> second : first.getValue().entrySet()) {
                if (map.containsKey(second.getKey()) && map.get(second.getKey()).containsKey(first.getKey()) && !second.getKey().equals(first.getKey())) {
                    ans += second.getValue() * map.get(second.getKey()).get(first.getKey());
                }
            }
        }
        out.println(ans / 2);
        out.close();
        br.close();
    }

    static class Pair {
        String a;
        String b;

        public Pair(String a, String b) {
            this.a = a;
            this.b = b;
        }
    }
}
