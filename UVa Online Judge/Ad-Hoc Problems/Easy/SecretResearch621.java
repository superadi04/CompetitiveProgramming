import java.util.Scanner;

class SecretResearch621 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        for (int i = 0; i < count; i++) {
            String current = s.next();
            if (current.equals("1") || current.equals("4") || current.equals("78")) {
                System.out.println("+");
            } else if (current.endsWith("35")) {
                System.out.println("-");
            } else if (current.startsWith("9") && current.endsWith("4")) {
                System.out.println("*");
            } else if (current.startsWith("190")) {
                System.out.println("?");
            }
        }
        s.close();
    }
}
