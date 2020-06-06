import java.util.Scanner;

public class PetyaAndStrings112A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String first = s.next().toLowerCase();
        String second = s.next().toLowerCase();
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            count = count + first.charAt(i) - second.charAt(i);
            if (count != 0) {
                break;
            }
        }
        if (count > 0) {
            System.out.print(1);
        } else if (count < 0) {
            System.out.print(-1);
        } else {
            System.out.print(0);
        }
    }
}

