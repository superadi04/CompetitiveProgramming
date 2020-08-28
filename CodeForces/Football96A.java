import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Football96A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char player = s.charAt(0);
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) == player) {
                count2++;
            } else {
                count2 = 0;
            }
            if (count2 > count) {
                count = count2;
            }
            player = s.charAt(i + 1);
        }
        if (count + 1 >= 7) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}
