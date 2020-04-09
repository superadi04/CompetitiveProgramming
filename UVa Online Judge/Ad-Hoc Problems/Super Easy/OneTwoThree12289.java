import java.util.Scanner;

class OneTwoThree12289 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numWords = s.nextInt();
        for (int i = 0; i < numWords; i++) {
            String word = s.next();
            if (word.length() == 3) {
                if ((word.charAt(0) == 'o' && word.charAt(1) == 'n') || (word.charAt(1) == 'n' && word.charAt(2) == 'e') || (word.charAt(0) == 'o' && word.charAt(2) == 'e')) {
                    System.out.println("1");
                } else {
                    System.out.println("2");
                }
            } else {
                System.out.println("3");
            }
        }
    }
}

