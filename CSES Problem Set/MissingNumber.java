import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<Integer>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                System.out.print(i);
                break;
            }
        }
    }
}
