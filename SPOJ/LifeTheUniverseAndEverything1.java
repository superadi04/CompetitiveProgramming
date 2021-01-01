import java.util.Scanner;

class LifeTheUniverseAndEverything {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int next;
        while ((next = s.nextInt()) != 42) {
            System.out.println(next);
        }
    }
}
