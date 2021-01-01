import java.io.*;
import java.util.*;

public class shuffle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        // The shuffle of the cows
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        // The final positions of the cows
        int[] fin = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fin[i] = Integer.parseInt(st.nextToken());
        }

        // Repeat the given shuffle 3 times
        for (int i = 0; i < 3; i++) {
            // Loop through the shuffle positions and set each cow to its original position
            int[] newShuffle = new int[n];
            for (int j = 0; j < n; j++) {
                newShuffle[j] = fin[seq[j]]; // Go to the previous position
            }
            fin = newShuffle; // Set the position of the cows as before the shuffle
        }

        // Our answer.
        for (int i : fin) {
            out.println(i);
        }
        out.close();
        br.close();
    }
}
