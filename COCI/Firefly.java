import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Firefly {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] stalagmite = new int[h + 1];
        int[] stalacite = new int[h + 1];
        int count = 0;
        int num = 1;
        for (int i = 1; i <= n; i++) {
            int o = Integer.parseInt(br.readLine());
            if ((i & 1) == 1) {
                stalagmite[o]++;
                count++;
            } else {
                stalacite[h - o]++;
                if (h - o == 0) count++;
            }
        }
        int currObstacles = count;
        for (int i = 2; i <= h; i++) {
            currObstacles = currObstacles - stalagmite[i - 1] + stalacite[i - 1];
            if (currObstacles < count) {
                count = currObstacles;
                num = 1;
            } else if (currObstacles == count) {
                num++;
            }
        }
        System.out.println(count + " " + num);
    }
}
