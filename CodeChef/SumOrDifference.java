import java.util.Scanner;

class SumOrDifference {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        if (n1 > n2) {
            System.out.print(n1 - n2);
        } else {
            System.out.print(n1 + n2);
        }
    }
}
