import java.io.*;
import java.util.*;

public class WrongSubtraction977A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            if (n % 10 == 0) {
                n /= 10;
            } else {
                --n;
            }
        }
        System.out.print(n);
    }
}