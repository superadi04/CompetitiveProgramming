import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cereal {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cereal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        first = new int[n];
        second = new int[n];
        cereals = new int[m];
        Arrays.fill(cereals, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            first[i] = Integer.parseInt(st.nextToken()) - 1;
            second[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            solve(i);
            ans[i] = currans;
        }
        for (int i : ans) {
            out.println(i);
        }
        out.close();
        br.close();
    }

    static int[] first; // First choice of cereal for cows
    static int[] second; // Second choice of cereal for cows
    static int[] cereals; // Contains index of cow per each cereal
    static int currans = 0;

    static void solve(int index) {
        if (cereals[first[index]] == Integer.MAX_VALUE) {
            cereals[first[index]] = index;
        } else {
            int currCereal = first[index]; // The current cereal being investigated
            int currIndex = index; // The index of the cow that will replace the given cereal
            while (true) {
                boolean test = false;
                if (cereals[currCereal] < currIndex) {
                    currans--;
                    break;
                } else if (cereals[currCereal] == Integer.MAX_VALUE) {
                    test = true;
                }
                int changeCereal = currCereal;
                int changeIndex = currIndex;
                if (!test) {
                    currCereal = second[cereals[changeCereal]];
                    currIndex = cereals[changeCereal];
                }
                cereals[changeCereal] = changeIndex;
                if (second[currIndex] == changeCereal) {
                    if (!test) currans--;
                    break;
                }
            }
        }
        currans++;
    }
}
