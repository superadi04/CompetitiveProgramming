import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class odometer {
    static HashSet<Long> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("odometer.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("odometer.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken()), y = Long.parseLong(st.nextToken());
        solve(x, y);
        out.println(set.size());
        out.close();
        br.close();
    }

    static void solve(long x, long y) {
        long[] num = new long[17];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(num, i);
            for (int j = 0; j < 17; j++) {
                for (int k = 0; k < 17; k++) {
                    for (int l = 0; l < 10; l++) {
                        num[j] = l;
                        checkIfInteresting(num,x,y,k);
                    }
                    num[j] = i;
                }
            }
        }
    }

    static void checkIfInteresting(long[] num, long x, long y, int currIndex) {
        StringBuilder sb = new StringBuilder();
        for (;currIndex < num.length; currIndex++) {
            sb.append(num[currIndex]);
        }
        long actualNumber = Long.parseLong(sb.toString());
        HashSet<Long> seen = new HashSet<>();
        long test = actualNumber;
        while (test > 0) {
            seen.add(test % 10);
            test /= 10;
        }
        if (actualNumber >= x && actualNumber <= y && seen.size() == 2) set.add(actualNumber);
    }
}