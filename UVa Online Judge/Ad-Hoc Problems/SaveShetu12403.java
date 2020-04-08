import java.util.Scanner;

public class SaveShetu12403 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int totalMoney = 0;
        for (int i = 0; i < t; i++) {
            String operation = s.next();
            if (operation.equals("donate")) {
                totalMoney += s.nextInt();
            } else {
                System.out.println(totalMoney);
            }
        }
    }
}
