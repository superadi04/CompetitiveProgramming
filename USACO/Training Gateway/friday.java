/*
ID: aditya.65
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;

class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] days = new int[7];

        int dayCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 12; j++) {
                int day = months[j];
                if (j == 1 && ((i + 1900) % 4 == 0 && (i + 1900) % 100 != 0 )) {
                    day = 29;
                } else if (j==1 && ((i + 1900) % 400 == 0)) {
                    day = 29;
                }
                for (int k = 0; k < day ; k++) {
                    if (k + 1 == 13) {
                        days[dayCount % 7]++;
                    }
                    dayCount++;
                }
            }
        }

        for (int i = 5; i < 11; i++) {
            out.print(days[i % 7] + " ");
        }
        out.println(days[4]);
        out.close();
    }
}
