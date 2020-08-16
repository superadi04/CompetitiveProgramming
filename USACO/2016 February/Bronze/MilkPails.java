import java.io.*;
import java.util.*;

public class MilkPails {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pails.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int maxDist = m;
        int xiterations = m / x;
        int yiterations = m / y;

        for (int i = 0; i <= xiterations; i++) {
            for (int j = 0; j <= yiterations; j++) {
                int milk = x * i + y * j;
                if (m - milk >= 0 && m - milk < maxDist) {
                    maxDist = m - milk;
                }
            }
        }
        out.print(m - maxDist);
        out.close();
    }
}
