import java.io.*;
import java.util.HashSet;

public class circlecross {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
        String s = br.readLine();
        int pairs = 0;
        HashSet<Character> finished = new HashSet<Character>();
        for (int j = 0; j < s.length() - 1; j++) {
            char c = s.charAt(j);
            HashSet<Character> set = new HashSet<Character>();
            int i = j + 1;
            while (i < s.length() && s.charAt(i) != c && !finished.contains(c)) {
                if (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(i));
                } else {
                    set.add(s.charAt(i));
                }
                ++i;
            }
            finished.add(c);
            pairs += set.size();
        }
        out.print(pairs / 2);
        out.close();
        br.close();
    }
}
