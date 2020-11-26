import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class cownomics {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] spotty = new char[n][m];
        char[][] plain = new char[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                spotty[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                plain[i][j] = s.charAt(j);
            }
        }
        int ans = 0;
        for (int j = 0; j < m; j++) {
            for (int k = j + 1; k < m; k++) {
                for (int l = k + 1; l < m; l++) {
                    HashSet<String> s = new HashSet<>();
                    HashSet<String> p = new HashSet<>();
                    for (int i = 0; i < n; i++) {
                        s.add(Character.toString(spotty[i][j]) + spotty[i][k] + spotty[i][l]);
                        p.add(Character.toString(plain[i][j]) + plain[i][k] + plain[i][l]);
                    }
                    HashSet<String> f = new HashSet<>();
                    f.addAll(s);
                    f.addAll(p);
                    if (s.size() + p.size() == f.size()) {
                        ans++;
                    }
                }
            }
        }
        out.print(ans);
        out.close();
        br.close();
    }
}
