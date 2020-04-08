import java.util.Scanner;

class HajjEAkbar12577 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input;
        int count = 1;
        while (!(input = s.nextLine()).equals("*")) {
            if (input.equals("Hajj")) {
                System.out.println("Case " + count + ": Hajj-e-Akbar");
            } else {
                System.out.println("Case " + count + ": Hajj-e-Asghar");
            }
            count++;
        }
        s.close();
    }
}
