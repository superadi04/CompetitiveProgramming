/*
ID: superadi04
LANG: JAVA
TASK: cbarn
*/

import java.io.*;
import java.util.ArrayList;

public class CircularBarn {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        int n = Integer.parseInt(b.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(b.readLine()));
        }

        int leastDist = n * n * 100;

        for (int i = 0; i < n; i++) {
            int totalDist = 0;
            for (int j = i + 1; j < n + i; j++) {
                totalDist += list.get(j % n) * (j - i);
            }
            if (leastDist > totalDist) {
                leastDist = totalDist;
            }
        }
        out.print(leastDist);
        out.close();
    }
}
