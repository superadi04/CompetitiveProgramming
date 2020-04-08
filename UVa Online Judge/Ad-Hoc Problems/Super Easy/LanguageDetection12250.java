import java.util.Scanner;

class LanguageDetection12250 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String word;
        int count = 1;
        while (!(word = s.next()).equals("#")) {
            if (word.equals("HELLO")) {
                System.out.println("Case " + count + ": ENGLISH");
            } else if (word.equals("HOLA")) {
                System.out.println("Case " + count + ": SPANISH");
            } else if (word.equals("HALLO")) {
                System.out.println("Case " + count + ": GERMAN");
            } else if (word.equals("BONJOUR")) {
                System.out.println("Case " + count + ": FRENCH");
            } else if (word.equals("CIAO")) {
                System.out.println("Case " + count + ": ITALIAN");
            } else if (word.equals("ZDRAVSTVUJTE")){
                System.out.println("Case " + count + ": RUSSIAN");
            } else {
                System.out.println("Case " + count + ": UNKNOWN");
            }
            count++;
        }
    }
}
