import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ClockwiseFence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int x = 0, y = 0;
            int sum = 0;
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                int newx = x;
                int newy = y;
                if (s.charAt(j) == 'N') newy++;
                if (s.charAt(j) == 'S') newy--;
                if (s.charAt(j) == 'E') newx++;
                if (s.charAt(j) == 'W') newx--;
                sum += (x * newy - newx * y);
                y = newy;
                x = newx;
            }
            if (sum < 0) {
                System.out.println("CW");
            } else {
                System.out.println("CCW");
            }
        }
    }
}
