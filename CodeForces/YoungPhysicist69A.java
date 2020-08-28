import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class YoungPhysicist69A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] vectors = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                vectors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean check = false;

        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += vectors[j][i];
            }
            if (count != 0) {
                check = true;
                break;
            }
        }
        if (check) {
            System.out.print("NO");
        } else {
            System.out.print("YES");
        }
    }
}
