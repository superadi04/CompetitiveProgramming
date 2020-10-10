import java.io.*;
import java.util.*;

public class CreatingStrings {
    static TreeSet<String> permutations = new TreeSet<String>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        search(s, "", new boolean[s.length()]);
        System.out.println(permutations.size());
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
        br.close();
    }

    public static void search(String input, String output, boolean[] chosen) {
        if (output.length() == input.length()) {
            permutations.add(output);
        } else {
            for (int i = 0; i < input.length(); i++) {
                if (chosen[i]) continue;
                chosen[i] = true;
                output += input.charAt(i);
                search(input, output, chosen);
                chosen[i] = false;
                output = output.substring(0, output.length() - 1);
            }
        }
    }
}
