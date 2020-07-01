import java.util.ArrayList;
import java.util.Scanner;

public class MusicalLoop11496 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        while ((n = s.nextInt()) != 0) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n + 2; i++) {
                if (list.size() >= n) {
                    list.add(list.get(i - n));
                    continue;
                }
                list.add(s.nextInt());
            }
            int peaks = 0;
            for (int i = 0; i < n; i++) {
                if (list.get(i + 1) > list.get(i) && list.get(i + 1) > list.get(i + 2) || list.get(i + 1) < list.get(i) && list.get(i + 1) < list.get(i + 2)) {
                    peaks++;
                }
            }
            System.out.println(peaks);
        }
    }
}
