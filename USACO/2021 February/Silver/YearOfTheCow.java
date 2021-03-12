import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class YearOfTheCow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] years = new int[n];
        for (int i = 0; i < n; i++) years[i] = Integer.parseInt(br.readLine());
        Arrays.sort(years);
        int currYear = 0;
        int ans = 0;
        ArrayList<Integer> spaces = new ArrayList<>();
        for (int i = 0; i < n;) {
            if (years[i] < currYear + 12) {
                while (i < n && currYear + 12 > years[i]) i++;
                currYear += 12;
                ans += 12;
            } else {
                int count = (years[i] - currYear) / 12;
                currYear += count * 12;
                spaces.add(count * 12);
            }
        }
        Collections.sort(spaces);
        for (int i = 0; i < spaces.size() - k + 1; i++) ans += spaces.get(i);
        System.out.println(ans);
    }
}
