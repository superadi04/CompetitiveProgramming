import java.io.*;
import java.util.*;
class TerribleChandu {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String snew = "";
            for (int j = s.length() -1; j >= 0; j--) {
                snew += s.charAt(j);
            }
            System.out.println(snew);
        }
    }
}