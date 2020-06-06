import java.util.Scanner;

public class WordCapitalization281A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String word = s.next();
        int first = word.charAt(0);
        String b = word.substring(0, 1);
        if (first > 96 && first < 123) {
            char a = (char) first;
            b = Character.toString(a).toUpperCase();
        }
        for (int i = 1; i < word.length(); i++) {
            b += word.charAt(i);
        }
        System.out.print(b);
    }
}
