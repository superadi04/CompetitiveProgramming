import java.util.ArrayList;
import java.util.Scanner;

class TEXQuotes00272 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        int count = 0;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '"') {
                    count++;
                    if (count == 1) {
                        list.add("``");
                    } else {
                        list.add("''");
                    }
                } else {
                    list.add(line.substring(i, i + 1));
                }
                if (count == 2) {
                    count = 0;
                }
            }
            for (int i = 0; i < line.length(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
            list.clear();
        }
    }
}
