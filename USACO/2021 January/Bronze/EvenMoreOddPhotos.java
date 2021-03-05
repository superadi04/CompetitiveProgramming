import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EvenMoreOddPhotos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int odd = 0, even = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x % 2 == 0) even++; else odd++;
        }
        while (Math.abs(even - odd) > 1) {
            if (even > odd) {
                even--;
            } else {
                odd -= 2;
                even++;
            }
        }
        if (odd - even == 1) odd -= 2;
        System.out.println(odd + even);
    }
}
