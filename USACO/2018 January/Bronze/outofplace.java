import java.io.*;
import java.util.*;

public class outofplace {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
        int n = Integer.parseInt(st.nextToken());
        int num = 0;
        int index = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            list.add(a);
            sorted.add(a);
        }
        Collections.sort(sorted);
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(sorted.get(i))) set.add(list.get(i));
        }
        out.print(set.size() - 1);
        out.close();
        br.close();
    }
}

