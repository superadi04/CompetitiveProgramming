/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: adityar9;
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
    public static void main (String [] args) throws IOException {
        Scanner s = new Scanner(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        int n = s.nextInt();
        String[] names = new String[n];
        int[] balances = new int[n];
        for (int i = 0; i < n; i++) {
            names[i] = s.next();
        }
        while (s.hasNext()) {
            String giver = s.next();
            int moneyToGive = s.nextInt();
            int numPeopleToGive = s.nextInt();
            if (numPeopleToGive != 0) {
                int moneyPerPerson = (int) Math.floor(moneyToGive / numPeopleToGive);
                for (int i = 1; i <= numPeopleToGive; i++) {
                    String receiver = s.next();
                    for (int j = 0; j < n; j++) {
                        if (receiver.equals(names[j])) {
                            balances[j] += moneyPerPerson;
                        }
                        if (giver.equals(names[j])) {
                            balances[j] -= moneyPerPerson;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.println(names[i] + " " + balances[i]);
        }
        out.close();
    }
}