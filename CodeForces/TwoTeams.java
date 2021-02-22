import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TwoTeams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> skills = new TreeMap<>();
        TreeMap<Integer, Integer> students = new TreeMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            students.put(i, a);
            skills.put(a, i);
        }
        int[] ans = new int[n];
        int currteam = 1;
        while (!students.isEmpty()) {
            int currindex = skills.get(skills.lastKey());
            ans[currindex] = currteam;
            skills.remove(skills.lastKey());
            int count = 0;
            while (currindex != students.lastKey() && count < k) {
                int higher = students.higherKey(currindex);
                ans[higher] = currteam;
                skills.remove(students.get(higher));
                students.remove(higher);
                count++;
            }
            count = 0;
            while (currindex != students.firstKey() && count < k) {
                int lower = students.lowerKey(currindex);
                ans[lower] = currteam;
                skills.remove(students.get(lower));
                students.remove(lower);
                count++;
            }
            students.remove(currindex);
            currteam = Math.abs(currteam - 3);
        }
        for (int i : ans) {
            System.out.print(i);
        }
    }
}
