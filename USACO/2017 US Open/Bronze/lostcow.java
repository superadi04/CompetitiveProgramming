import java.io.*;
import java.util.StringTokenizer;

public class lostcow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int original = x;
        int dist = 0;
        int power = 0;
        while (true) {
            if (power % 2 == 0) {
                x += Math.pow(2, power);
                dist += Math.pow(2, power);
            } else {
                x -= Math.pow(2, power);
                dist += Math.pow(2, power);
            }

            if (original < y && x >= y) {
                break;
            }
            if (original > y && x <= y) {
                break;
            }
            dist += Math.pow(2, power);
            x = original;
            power++;
        }

        out.print(dist - Math.abs(x - y));
        out.close();
    }
}
