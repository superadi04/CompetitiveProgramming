import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class HelpfulMaths339A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        String sum = s.next();
        for (int i = 0; i < sum.length(); i+=2) {
            list.add(parseInt(sum.substring(i, i + 1)));
        }
        Collections.sort(list);
        System.out.print(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            System.out.print("+" + list.get(i));
        }
    }
}
