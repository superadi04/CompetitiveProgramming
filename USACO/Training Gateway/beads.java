/*
ID: aditya.65
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;

public class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("beads.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char[] necklace = new char[n * 2];
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        boolean test = true;
        for (int i = 0; i < n; i++) {
            necklace[i] = s.charAt(i);
        }
        for (int i = n; i < n * 2; i++) {
            necklace[i] = necklace[i % n];
        }

        for (int i = 0; i < n-1; i++) {
            if (necklace[i] != necklace[i + 1]) {
                test = false;
            }
        }
        int maxBeads = 0;
        if (!test) {
            for (int i = 0; i < n; i++) {
                char bead;
                int count = i;
                while (count < n * 2 && necklace[count] == 'w') {
                    count++;
                }

                bead = necklace[count];
                while (count < n * 2 && (necklace[count] == bead || necklace[count] == 'w')) {
                    count++;
                }
                bead = necklace[count];
                while (count < n * 2 && (necklace[count] == bead || necklace[count] == 'w')) {
                    count++;
                }

                if (count - i > maxBeads && count - i <= n) {
                    maxBeads = count - i;
                } else if (count - i > n) {
                    maxBeads = n;
                }
            }
        }
        if (!test) {
            out.println(maxBeads);
        } else {
            out.println(n);
        }

        out.close();
    }
}
