import java.io.*;
import java.util.*;

public class PreparingForMergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        TreeMap<Integer, ArrayList<Integer>> finished = new TreeMap<>();
        ArrayList<Integer> curr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (curr.size() > 0 && finished.size() > 0 && finished.floorKey(list.get(i)) != null && list.get(i) - finished.floorKey(list.get(i)) < list.get(i) - curr.get(curr.size() - 1)) {
                ArrayList<Integer> a = finished.get(finished.floorKey(list.get(i)));
                a.add(list.get(i));
                finished.remove(finished.floorKey(list.get(i)));
                finished.put(list.get(i), a);
                continue;
            }
            if (curr.size() > 0 && curr.get(curr.size() - 1) > list.get(i)) {
                finished.put(curr.get(curr.size() - 1), curr);
                curr = new ArrayList<>();
                --i;
            } else {
                curr.add(list.get(i));
            }
        }
        if (curr.size() > 0) {
            finished.put(curr.get(curr.size() - 1), curr);
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry: finished.descendingMap().entrySet()) {
            for (int i : entry.getValue()) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
