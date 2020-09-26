import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class StickLengths {
    static ArrayList<Long> list = new ArrayList<Long>();
    static long ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(list);
        long med = list.get(list.size() / 2);
        for (int i = 0; i < n; i++) {
            ans += Math.abs(list.get(i) - med);
        }
        System.out.print(ans);
        br.close();
    }
}
