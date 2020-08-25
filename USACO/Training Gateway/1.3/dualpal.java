/*
ID: adityar9
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.*;

public class dualpal {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        ++s;
        int count = 0;
        while (count < n) {
            if (isPalindromic(s)) {
                out.println(s);
                ++count;
            }
            ++s;
        }
        out.close();
    }

    public static boolean isPalindromic(int a) {
        int count = 0;

        for (int i = 2; i <= 10; ++i) {
            int temp = a;
            int power = 1;
            while (a >= Math.pow(i, power)) {
                ++power;
            }
            int[] arr = new int[power];
            --power;

            for (int j = 0; j < arr.length; j++) {
                int mult = 0;
                while (temp >= Math.pow(i, power) * mult && mult < i) {
                    ++mult;
                }
                temp -= Math.pow(i, power) * (mult - 1);
                --power;
                arr[j] = mult - 1;
            }

            if (checkPalindromic(arr)) {
                count++;
            }
        }
        return count >= 2;
    }

    public static boolean checkPalindromic(int[] arr) {
        String a = "";
        String b = "";

        for (int i = 0; i < arr.length; i++) {
            a += arr[i];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            b += arr[i];
        }

        return a.equals(b);
    }
}
