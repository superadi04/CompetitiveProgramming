import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TrafficLights {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(0);
        set.add(x);

        st = new StringTokenizer(r.readLine());
        int maxDist = 0;
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            set.add(p);
            int setter = 0;
            for (int j = 0; j < set.size() - 1; j++) {
                int higher = set.higher(setter);
                maxDist = Math.max(maxDist, higher - setter);
                setter = higher;
            }
            System.out.print(maxDist + " ");
            maxDist = 0;
        }
    }
}
