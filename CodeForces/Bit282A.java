import java.util.Scanner;

public class Bit282A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        int x = 0;
        for (int i = 0; i < count; i++) {
            String operation = s.next();
            if (operation.equals("++X") || operation.equals("X++")) {
                x++;
            } else {
                x--;
            }
        }
        System.out.println(x);
    }
}
