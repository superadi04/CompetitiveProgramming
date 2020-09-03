import java.io.*;
import java.util.StringTokenizer;

public class SquarePasture {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("square.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
        int[] x = new int[4];
        int[] y = new int[4];

        for (int i = 0; i < 4; i+=2) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            x[i + 1] = Integer.parseInt(st.nextToken());
            y[i + 1] = Integer.parseInt(st.nextToken());
        }

        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                int xdiff = Math.abs(x[j] - x[i]);
                int ydiff = Math.abs(y[j] - y[i]);
                if (xdiff > maxX) {
                    maxX = xdiff;
                }
                if (ydiff > maxY) {
                    maxY = ydiff;
                }
            }
        }
        int max = Math.max(maxX, maxY);
        out.print(max * max);
        out.close();
        br.close();
    }
}
