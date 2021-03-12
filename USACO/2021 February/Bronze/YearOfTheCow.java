import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class YearOfTheCow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // Construct calendar
        String[] cycle = new String[12];

        cycle[0] = "Ox";
        cycle[1] = "Tiger";
        cycle[2] = "Rabbit";
        cycle[3] = "Dragon";
        cycle[4] = "Snake";
        cycle[5] = "Horse";
        cycle[6] = "Goat";
        cycle[7] = "Monkey";
        cycle[8] = "Rooster";
        cycle[9] = "Dog";
        cycle[10] = "Pig";
        cycle[11] = "Rat";

        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Bessie", 120000);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            st.nextToken();
            st.nextToken();
            String beforeOrAfter = st.nextToken();
            String year = st.nextToken();
            st.nextToken();
            st.nextToken();
            String prevCow = st.nextToken();

            if (beforeOrAfter.equals("previous")) {
                int currYear = ages.get(prevCow);
                int count = 0;
                for (int j = currYear - 1;; j--) {
                    count++;
                    if (cycle[j % 12].equals(year)) {
                        break;
                    }
                }
                ages.put(name, currYear - count);
            } else {
                int currYear = ages.get(prevCow);
                int count = 0;
                for (int j = currYear + 1;; j++) {
                    count++;
                    if (cycle[j % 12].equals(year)) {
                        break;
                    }
                }
                ages.put(name, currYear + count);
            }
        }
        System.out.println(Math.abs(ages.get("Bessie") - ages.get("Elsie")));
    }
}
