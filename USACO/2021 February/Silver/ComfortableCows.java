import java.io.*;
import java.util.*;

public class ComfortableCows {
    static boolean[][] cows;
    static boolean[][] imaginaryCows;
    static int imaginaryCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        cows = new boolean[2001][2001];
        imaginaryCows = new boolean[2001][2001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 500;
            int y = Integer.parseInt(st.nextToken()) + 500;
            add(x, y);
            System.out.println(imaginaryCount);
        }
    }

    static void add(int x, int y) {
        cows[x][y] = true;
        if(imaginaryCows[x][y]) imaginaryCount--;
        imaginaryCows[x][y] = false;
        floodfill(x + 1, y);
        floodfill(x - 1, y);
        floodfill(x, y + 1);
        floodfill(x, y - 1);
        floodfill(x, y);
    }

    static boolean floodfill(int x, int y) {
        if (x > 2000 || x < 0 || y > 2000 || y < 0) return false;
        if (!cows[x][y] && !imaginaryCows[x][y]) return false;
        int[] check = checkComfort(x, y);
        if (check == null) return false;
        imaginaryCows[check[0]][check[1]] = true;
        imaginaryCount++;
        floodfill(check[0] + 1, check[1]);
        floodfill(check[0] - 1, check[1]);
        floodfill(check[0], check[1] + 1);
        floodfill(check[0], check[1] - 1);
        floodfill(check[0], check[1]);
        return true;
    }

    static int[] checkComfort(int x, int y) {
        int count = 0;
        int[] availableSpot = new int[2];
        if (x + 1 <= 2000 && (cows[x + 1][y] || imaginaryCows[x + 1][y])) {
            count++;
        } else {
            availableSpot[0] = x + 1;
            availableSpot[1] = y;
        }
        if (x - 1 >= 0 && (cows[x - 1][y] || imaginaryCows[x - 1][y])) {
            count++;
        } else {
            availableSpot[0] = x - 1;
            availableSpot[1] = y;
        }
        if (y + 1 <= 2000 && (cows[x][y + 1] || imaginaryCows[x][y + 1])) {
            count++;
        } else {
            availableSpot[0] = x;
            availableSpot[1] = y + 1;
        }
        if (y - 1 >= 0 && (cows[x][y - 1] || imaginaryCows[x][y - 1])) {
            count++;
        } else {
            availableSpot[0] = x;
            availableSpot[1] = y - 1;
        }
        return (count != 3) ? null : availableSpot;
    }
}
