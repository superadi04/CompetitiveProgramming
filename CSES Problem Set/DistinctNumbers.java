import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class DistinctNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numValues = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numValues; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        System.out.print(set.size());
    }
}
