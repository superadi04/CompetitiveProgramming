import java.util.ArrayList;
import java.util.Scanner;

public class StringTask118A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String word = s.next().toLowerCase();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (!((word.charAt(i) == 'a') || (word.charAt(i) == 'e') || (word.charAt(i) == 'i') || (word.charAt(i) == 'o') || (word.charAt(i) == 'u') || (word.charAt(i) == 'y'))) {
                list.add(word.substring(i, i + 1));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print("." + list.get(i));
        }
    }
}
