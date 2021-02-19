import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UdderedButNotHerd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String alphabet = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String heard = st.nextToken();

        int ans = 0;
        int heardIndex = 0;

        outer: while (heardIndex < heard.length()) {
            ans++;
            for (int i = 0; i < alphabet.length(); i++) {
                if (alphabet.charAt(i) == heard.charAt(heardIndex)) {
                    heardIndex++;
                }
                if (heardIndex == heard.length()) break outer;
            }
        }

        System.out.println(ans);
    }
}
