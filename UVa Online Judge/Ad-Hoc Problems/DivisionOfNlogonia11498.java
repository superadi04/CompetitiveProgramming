import java.util.Scanner;

class DivisionOfNlogonia11498 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        while (k != 0) {
            int divisionX = s.nextInt();
            int divisionY = s.nextInt();
            for (int i = 0; i < k; i++) {
                int x = s.nextInt();
                int y = s.nextInt();
                if (x > divisionX && y > divisionY) {
                    System.out.println("NE");
                } else if (x > divisionX && y < divisionY) {
                    System.out.println("SE");
                } else if (x < divisionX && y > divisionY) {
                    System.out.println("NO");
                } else if (x < divisionX && y < divisionY) {
                    System.out.println("SO");
                } else {
                    System.out.println("divisa");
                }
            }
            k = s.nextInt();
        }
    }
}
