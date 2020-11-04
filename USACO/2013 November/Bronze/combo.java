import java.io.*;
import java.util.StringTokenizer;

public class combo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("combo.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        int n = Integer.parseInt(st.nextToken());
        int[] john = new int[3];
        int[] master = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            john[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            master[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int total = (int) Math.min(Math.pow(n, 3), 250);
        for (int i = 0; i < 3; i++) {
            int curr = Math.min(Math.abs(master[i] - john[i]), Math.abs(n - Math.max(master[i], john[i]) + Math.min(master[i], john[i])));
            if (curr <= 4) {
                if (ans == 0) ++ans;
                ans *= -curr + 5;
            }
        }
        out.print((total <= ans) ? total : total - ans);
        out.close();
        br.close();
    }
}
