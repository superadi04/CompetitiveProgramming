import java.util.Scanner;

public class TheatreSquare1A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double n = s.nextDouble();
        double m = s.nextDouble();
        double a = s.nextDouble();
        System.out.print((long) (Math.ceil(n / a) * Math.ceil(m / a)));
    }
}
