/*
ID: adityar9
LANG: JAVA
TASK: palsquare
*/

import java.util.*;
import java.io.*;

class palsquare {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= 300; i++) {
            String s = baseConvert("" + i * i, 10, n);
            if (s.equals(new StringBuilder(s).reverse().toString())) {
                out.println(baseConvert("" + i, 10, n).toUpperCase() + " " + baseConvert("" + i * i, 10, n).toUpperCase());
            }
        }
        out.close();
        br.close();
    }
    
    static String baseConvert(String num, int baseBefore, int baseAfter) {
        return Integer.toString(Integer.parseInt(num, baseBefore), baseAfter);
    }
}