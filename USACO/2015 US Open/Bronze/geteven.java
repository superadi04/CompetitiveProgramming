import java.io.*;
import java.util.*;

public class geteven {
    static int[][] arr = new int[7][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("geteven.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("geteven.out")));
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            assign(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
        }
        int ans = 0;
        for (int a = 1; a <= 2; a++) {
            for (int b = 1; b <= 2; b++) {
                for (int c = 1; c <= 2; c++) {
                    for (int d = 1; d <= 2; d++) {
                        for (int e = 1; e <= 2; e++) {
                            for (int f = 1; f <= 2; f++) {
                                for (int g = 1; g <= 2; g++) {
                                    if (((a + b + c + c + d + b) * (e + f + b + c) * (g + f + f) % 2) == 0) {
                                        ans += arr[0][a - 1] * arr[1][b - 1] * arr[2][c - 1] * arr[3][d - 1] * arr[4][e - 1] * arr[5][f - 1] * arr[6][g - 1];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        out.print(ans);
        out.close();
        br.close();
    }

    public static void assign(char c, int n) {
        if (c == 'B') {
            evenAssign(n, 0);
        } else if (c == 'E') {
            evenAssign(n, 1);
        } else if (c == 'S') {
            evenAssign(n, 2);
        } else if (c == 'I') {
            evenAssign(n, 3);
        } else if (c == 'G') {
            evenAssign(n, 4);
        } else if (c == 'O') {
            evenAssign(n, 5);
        } else if (c == 'M') {
            evenAssign(n, 6);
        }
    }

    public static void evenAssign(int n, int index) {
        if (n % 2 == 0) {
            ++arr[index][1];
        } else {
            ++arr[index][0];
        }
    }
}
