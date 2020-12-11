/*
ID: adityar9
LANG: JAVA
TASK: transform
*/

import java.io.*;
import java.util.*;

class transform {
    static int n;
    static char[][] before;
    static char[][] after;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        before = new char[n][n];
        after = new char[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                before[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                after[i][j] = s.charAt(j);
            }
        }
        if (check(one(before))) {
            out.println(1);
        } else if (check(two(before))) {
            out.println(2);
        } else if (check(three(before))) {
            out.println(3);
        } else if (check(four(before))) {
            out.println(4);
        } else if (check(one(four(before))) || check(two(four(before))) || check(three(four(before)))) {
            out.println(5);
        } else if (check(before)) {
            out.println(6);
        } else {
            out.println(7);
        }
        out.close();
    }

    static char[][] one(char[][] prev) {
        char[][] transform = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transform[j][n - i - 1] = prev[i][j];
            }
        }
        return transform;
    }

    static char[][] two(char[][] prev) {
        char[][] transform = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transform[n - i - 1][n - j - 1] = prev[i][j];
            }
        }
        return transform;
    }

    static char[][] three(char[][] prev) {
        char[][] transform = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transform[j][i] = prev[i][j];
            }
        }
        return transform;
    }

    static char[][] four(char[][] prev) {
        char[][] transform = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transform[i][n - j - 1] = prev[i][j];
            }
        }
        return transform;
    }

    static boolean check(char[][] transform) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (transform[i][j] != after[i][j]) return false;
            }
        }
        return true;
    }
}
