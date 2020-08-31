import java.io.*;
import java.util.*;

public class PikachuAndTheGameOfStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        String t = br.readLine();
        int days = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 65;
            int b = t.charAt(i) - 65;
            while (a != b) {
                if ((a > b && ((26 - a) + b) >= 13) || (a < b && ((b - a) >= 13))) {
                    a = (a + 13) % 26;
                } else {
                    a = (a + 1) % 26;
                }
                days++;
            }
        }
        System.out.print(days);
    }
}
