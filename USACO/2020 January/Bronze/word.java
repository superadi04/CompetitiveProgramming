import java.io.*;
import java.util.StringTokenizer;

public class word {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("word.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = st.nextToken();
        }
        String line = "";
        int countSpaces = 0;
        for (int i = 0; i < n - 1; i++) {
            if (line.length() + words[i].length() - countSpaces <= k) {
                line += words[i];
            } else {
                countSpaces = 0;
                out.println(line);
                line = words[i];
            }
            if (line.length() + words[i + 1].length() - countSpaces <= k) {
                line += " ";
                ++countSpaces;
            }
        }
        if (words[n - 1].length() + line.length() - countSpaces<= k) {
            out.print(line + words[n - 1]);
        } else {
            out.println(line);
            out.print(words[n - 1]);
        }
        out.close();
        br.close();
    }
}
