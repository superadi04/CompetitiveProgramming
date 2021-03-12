import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String s = br.readLine();
            StringBuilder ans = new StringBuilder();
            int prefix = 0;
            for (int j = 0; j < s.length(); j++) {
                int currPrefix = prefix;
                int x = Integer.parseInt(String.valueOf(s.charAt(j)));
                if (x < currPrefix) {
                    for (int k = 0; k < currPrefix - x; k++) {
                        ans.append(')');
                        prefix--;
                    }
                } else {
                    for (int k = 0; k < x - currPrefix; k++) {
                        ans.append('(');
                        prefix++;
                    }
                }
                ans.append(x);
            }
            for (int j = 0; j < prefix; j++) ans.append(')');
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}
