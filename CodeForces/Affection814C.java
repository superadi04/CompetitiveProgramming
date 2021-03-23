import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Affection814C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[][] lookup = new int[26][n+1];
        for (char c='a'; c<='z';c++) {
            for (int j = 1; j <= n; j++) {
                int max = 0;
                int currPiecesToRepaint = 0;
                int l = 0;
                for (int k = 0; k < n; k++) {
                    if (k > 0 && s.charAt(k - 1) != c) currPiecesToRepaint--;
                    while (l < n && (currPiecesToRepaint < j|| s.charAt(l) == c)) {
                        if (s.charAt(l) != c) {
                            currPiecesToRepaint++;
                        }
                        l++;
                    }
                    max = Math.max(max, l - k);
                    if (l == n) break;
                }
                lookup[c-97][j] = max;
            }
        }
        int q = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            System.out.println(lookup[c-97][m]);
        }
    }
}
