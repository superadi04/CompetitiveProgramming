import java.io.*;
import java.util.*;

public class cardgame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cardgame.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cardgame.out")));
        int n = Integer.parseInt(br.readLine());
        int[] higher = new int[n / 2];
        int[] lower = new int[n / 2];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n / 2; i++) { higher[i] = Integer.parseInt(br.readLine()); set.add(higher[i]); }
        for (int i = 0; i < n / 2; i++) { lower[i] = Integer.parseInt(br.readLine()); set.add(lower[i]); }
        Arrays.sort(higher);
        Arrays.sort(lower);
        int[] bessie = new int[n]; int index = 0;
        for (int i = 1; i <= 2 * n; i++) if (!set.contains(i)) bessie[index++] = i;
        Arrays.sort(bessie);
        TreeSet<Integer> beathigher = new TreeSet<>();
        TreeSet<Integer> beatlower = new TreeSet<>();
        for (int i = 0; i < n; i++) if (i < n / 2) beatlower.add(bessie[i]); else beathigher.add(bessie[i]);
        int ans = 0;
        for (int i = n / 2 - 1; i >= 0; i--) {
            int highest = beathigher.last();
            if (higher[i] < highest) {
                ans++;
                beathigher.remove(highest);
            } else {
                beathigher.remove(beathigher.first());
            }
        }
        for (int i = 0; i < n / 2; i++) {
            int lowest = beatlower.first();
            if (lower[i] > lowest) {
                ans++;
                beatlower.remove(lowest);
            } else {
                beatlower.remove(beatlower.last());
            }
        }
        out.println(ans);
        out.close();
        br.close();
    }
}
