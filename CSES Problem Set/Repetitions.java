import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int maxLen = 0;
        int len = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                len++;
            } else {
                len = 0;
            }
            if (len > maxLen) {
                maxLen = len;
            }
        }
        System.out.print(maxLen + 1);
    }
}
