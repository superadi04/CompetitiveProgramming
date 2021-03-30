import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class leftout {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("leftout.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("leftout.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char[][] grid = new char[n][n];
        boolean[][] vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        String[] rows = new String[n];
        String[] columns = new String[n];
        HashMap<String, Integer> rowmap = new HashMap<>();
        HashMap<String, Integer> columnmap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 'L') {
                    if (grid[i][0] == 'R') {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                } else {
                    if (grid[i][0] == 'L') {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                }
            }
            rows[i] = sb.toString();
            if (rowmap.containsKey(rows[i])) {
                rowmap.put(rows[i], rowmap.get(rows[i]) + 1);
            } else {
                rowmap.put(rows[i], 1);
            }
        }

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            for (int j = 1; j < n; j++) {
                if (grid[j][i] == 'L') {
                    if (grid[0][i] == 'R') {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                } else {
                    if (grid[0][i] == 'L') {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                }
            }
            columns[i] = sb.toString();
            if (columnmap.containsKey(columns[i])) {
                columnmap.put(columns[i], columnmap.get(columns[i]) + 1);
            } else {
                columnmap.put(columns[i], 1);
            }
        }

        int rowCount = 0, columnCount = 0;
        String maxRow = "", maxColumn = "";
        for (Map.Entry<String, Integer> entry : rowmap.entrySet()) {
            if (entry.getValue() > rowCount) {
                rowCount = entry.getValue();
                maxRow = entry.getKey();
            }
        }
        for (Map.Entry<String, Integer> entry : columnmap.entrySet()) {
            if (entry.getValue() > columnCount) {
                columnCount = entry.getValue();
                maxColumn = entry.getKey();
            }
        }

        for (int i = 0; i < n; i++) {
            if (rows[i].equals(maxRow)) {
                for (int j = 0; j < n; j++) {
                    vis[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (columns[i].equals(maxColumn)) {
                for (int j = 0; j < n; j++) {
                    vis[j][i] = true;
                }
            }
        }

        int r = 0, c = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    r = i + 1;
                    c = j + 1;
                    count++;
                }
            }
        }

        if (count == 1) {
            out.println(r + " " + c);
        } else {
            out.println(-1);
        }
        out.close();
        br.close();
    }
}
