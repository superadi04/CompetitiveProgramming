import java.io.*;
import java.util.StringTokenizer;

public class SpeedingTicket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] roadSegments = new int[100];
        int[] bessieSegments = new int[100];

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            for (int j = 0 + count; j < length + count; j++) {
                roadSegments[j] = limit;
            }
            count += length;
        }
        count = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            for (int j = 0 + count; j < length + count; j++) {
                bessieSegments[j] = limit;
            }
            count += length;
        }

        int maxOverLimit = 0;
        for (int i = 0; i < 100; i++) {
            if (bessieSegments[i] - roadSegments[i] > maxOverLimit) {
                maxOverLimit = bessieSegments[i] - roadSegments[i];
            }
        }
        out.print(maxOverLimit);
        out.close();
    }
}
