/*
ID: adityar9
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String a = f.readLine();
        String b = f.readLine();
        int counta = 1;
        int countb = 1;
        for (int i = 0; i < a.length(); i++) {
            counta = counta * ((int) (a.charAt(i) - 'A') + 1);
            System.out.print(counta + " ");
        }
        System.out.println();
        for (int i = 0; i < b.length(); i++) {
            countb = countb * ((int) (b.charAt(i) - 'A') + 1);
            System.out.print(countb + " ");
        }
        if (counta % 47 == countb % 47) {
            out.println("GO");
        } else {
            out.println("STAY");
        }
        out.close();                                 
    }
}