import java.io.*;
import java.util.*;

public class moocrypt {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("moocrypt.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocrypt.out")));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] puzzle = new char[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                puzzle[i][j] = s.charAt(j);
            }
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // Check Rows
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 2; j++) {
                //System.out.println(puzzle[i][j] + Character.toString(puzzle[i][j + 1]) + puzzle[i][j + 2]);
                if (puzzle[i][j] == puzzle[i][j + 1] && puzzle[i][j + 2] != puzzle[i][j] || puzzle[i][j + 1] == puzzle[i][j + 2] && puzzle[i][j + 2] != puzzle[i][j]) {
                    if (map.containsKey(puzzle[i][j] + Character.toString(puzzle[i][j + 1]) + puzzle[i][j + 2])) {
                        map.put(puzzle[i][j] + Character.toString(puzzle[i][j + 1]) + puzzle[i][j + 2], map.get(puzzle[i][j] + Character.toString(puzzle[i][j + 1]) + puzzle[i][j + 2]) + 1);
                    } else if (map.containsKey(puzzle[i][j + 2] + Character.toString(puzzle[i][j + 1]) + puzzle[i][j])) {
                        map.put(puzzle[i][j + 2] + Character.toString(puzzle[i][j + 1]) + puzzle[i][j], map.get(puzzle[i][j + 2] + Character.toString(puzzle[i][j + 1]) + puzzle[i][j]) + 1);
                    } else {
                        map.put(puzzle[i][j] + Character.toString(puzzle[i][j + 1]) + puzzle[i][j + 2], 1);
                    }
                }
            }
        }
        // Check Columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 2; j++) {
                //System.out.println(puzzle[j][i] + Character.toString(puzzle[j + 1][i]) + puzzle[j + 2][i]);
                if (puzzle[j][i] == puzzle[j + 1][i] && puzzle[j][i] != puzzle[j + 2][i] || puzzle[j + 1][i] == puzzle[j + 2][i] && puzzle[j][i] != puzzle[j + 2][i]) {
                    if (map.containsKey(puzzle[j][i] + Character.toString(puzzle[j + 1][i]) + puzzle[j + 2][i])) {
                        map.put(puzzle[j][i] + Character.toString(puzzle[j + 1][i]) + puzzle[j + 2][i], map.get(puzzle[j][i] + Character.toString(puzzle[j + 1][i]) + puzzle[j + 2][i]) + 1);
                    } else if (map.containsKey(puzzle[j + 2][i] + Character.toString(puzzle[j + 1][i]) + puzzle[j][i])) {
                        map.put(puzzle[j + 2][i] + Character.toString(puzzle[j + 1][i]) + puzzle[j][i], map.get(puzzle[j + 2][i] + Character.toString(puzzle[j + 1][i]) + puzzle[j][i]) + 1);
                    } else {
                        map.put(puzzle[j][i] + Character.toString(puzzle[j + 1][i]) + puzzle[j + 2][i], 1);
                    }
                }
            }
        }

        // Check Diagonals Going to Right
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                //System.out.println(puzzle[i][j] + Character.toString(puzzle[i + 1][j + 1]) + puzzle[i + 2][j + 2]);
                if (puzzle[i][j] == puzzle[i + 1][j + 1] && puzzle[i][j] != puzzle[i + 2][j + 2] || puzzle[i + 1][j + 1] == puzzle[i + 2][j + 2] && puzzle[i][j] != puzzle[i + 2][j + 2]) {
                    if (map.containsKey(puzzle[i][j] + Character.toString(puzzle[i + 1][j + 1]) + puzzle[i + 2][j + 2])) {
                        map.put(puzzle[i][j] + Character.toString(puzzle[i + 1][j + 1]) + puzzle[i + 2][j + 2], map.get(puzzle[i][j] + Character.toString(puzzle[i + 1][j + 1]) + puzzle[i + 2][j + 2]) + 1);
                    } else if (map.containsKey(puzzle[i + 2][j + 2] + Character.toString(puzzle[i + 1][j + 1]) + puzzle[i][j])) {
                        map.put(puzzle[i + 2][j + 2] + Character.toString(puzzle[i + 1][j + 1]) + puzzle[i][j], map.get(puzzle[i + 2][j + 2] + Character.toString(puzzle[i + 1][j + 1]) + puzzle[i][j]) + 1);
                    } else {
                        map.put(puzzle[i][j] + Character.toString(puzzle[i + 1][j + 1]) + puzzle[i + 2][j + 2], 1);
                    }
                }
            }
        }
        // Check Diagonals Going to Left
        for (int i = 0; i < n - 2; i++) {
            for (int j = m - 1; j >= 2; j--) {
                //System.out.println(puzzle[i][j] + Character.toString(puzzle[i + 1][j - 1]) + puzzle[i + 2][j - 2]);
                if (puzzle[i][j] == puzzle[i + 1][j - 1] && puzzle[i][j] != puzzle[i + 2][j - 2] || puzzle[i + 1][j - 1] == puzzle[i + 2][j - 2] && puzzle[i][j] != puzzle[i + 2][j - 2]) {
                    if (map.containsKey(puzzle[i][j] + Character.toString(puzzle[i + 1][j - 1]) + puzzle[i + 2][j - 2])) {
                        map.put(puzzle[i][j] + Character.toString(puzzle[i + 1][j - 1]) + puzzle[i + 2][j - 2], map.get(puzzle[i][j] + Character.toString(puzzle[i + 1][j - 1]) + puzzle[i + 2][j - 2]) + 1);
                    } else if (map.containsKey(puzzle[i + 2][j - 2] + Character.toString(puzzle[i + 1][j - 1]) + puzzle[i][j])) {
                        map.put(puzzle[i + 2][j - 2] + Character.toString(puzzle[i + 1][j - 1]) + puzzle[i][j], map.get(puzzle[i + 2][j - 2] + Character.toString(puzzle[i + 1][j - 1]) + puzzle[i][j]) + 1);
                    } else {
                        map.put(puzzle[i][j] + Character.toString(puzzle[i + 1][j - 1]) + puzzle[i + 2][j - 2], 1);
                    }
                }
            }
        }

        // Get Max
        int ans = 0;
        for (Map.Entry i : map.entrySet()) {
            String s = (String) i.getKey();
            if ((s.charAt(0) != 'M' && s.charAt(1) != 'O') || (s.charAt(2) != 'M' && s.charAt(1) != 'O')) ans = Math.max(ans, (Integer) i.getValue());
        }
        out.print(ans);
        out.close();
        br.close();
    }
}
