import java.io.*;
import java.util.*;

public class angry {
    static ArrayList<Long> blast = new ArrayList<Long>();
    static int max = 1;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            blast.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(blast);
        for (int i = 0; i < n; i++) {
            max = Math.max(max, 1 + countLeft(i) + countRight(i));
        }
        out.print(max);
        out.close();
        br.close();
    }

    public static int countLeft(int index) {
        long curr = blast.get(index);
        int currRadius = 1;
        int originalIndex = index;
        while (index > 0 && blast.get(index - 1) + currRadius >= curr) {
            while (index > 0 && blast.get(index - 1) + currRadius >= curr) {
                --index;
            }
            curr = blast.get(index);
            ++currRadius;
        }
        return originalIndex - index;
    }

    public static int countRight(int index) {
        long curr = blast.get(index);
        int currRadius = 1;
        int originalIndex = index;
        while (index < blast.size() - 1 && blast.get(index + 1) - currRadius <= curr) {
            while (index < blast.size() - 1 && blast.get(index + 1) - currRadius <= curr) {
                ++index;
            }
            curr = blast.get(index);
            ++currRadius;
        }
        return index - originalIndex;
    }
}
