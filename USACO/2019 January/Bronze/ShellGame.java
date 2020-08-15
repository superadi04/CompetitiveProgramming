import java.io.*;
import java.util.StringTokenizer;

public class ShellGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] pebbles = new int[3];
        for (int i = 0; i < 3; i++) {
            pebbles[i] = 1 + i;
        }
        int[] count = new int[3];
        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            int swap = pebbles[b - 1];
            pebbles[b - 1] = pebbles[a - 1];
            pebbles[a - 1] = swap;

            int x = pebbles[g-1];
            if (x == 1) {
                count[0]++;
            } else if (x == 2) {
                count[1]++;
            } else {
                count[2]++;
            }
        }

        int max = 0;
        for(int num : count) {
            if (num > max) {
                max = num;
            }
        }
        out.print(max);
        out.close();
    }
}
