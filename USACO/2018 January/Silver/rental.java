import java.io.*;
import java.util.*;

public class rental {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("rental.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long ans = 0;
        Long[] cows = new Long[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = Long.parseLong(st.nextToken());
        }
        Store[] stores = new Store[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            stores[i] = new Store(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }
        Long[] rents = new Long[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rents[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(cows, Collections.reverseOrder());
        Arrays.sort(stores, Collections.reverseOrder());
        Arrays.sort(rents, Collections.reverseOrder());
        long[] storeCounts = new long[m];
        for (int i = 0; i < m; i++) {
            storeCounts[i] = stores[i].q;
        }
        Long[] cowsClone = cows.clone();
        int storeIndex = 0;
        int cowsIndex = 0;
        long currSum = 0;
        long[] cowPrices = new long[n];
        while (storeIndex < m && cowsIndex < n) {
            long original = storeCounts[storeIndex];
            storeCounts[storeIndex] = Math.max(0, storeCounts[storeIndex] - cowsClone[cowsIndex]);
            cowsClone[cowsIndex] = Math.max(0, cowsClone[cowsIndex] - original);
            currSum += (original - storeCounts[storeIndex]) * stores[storeIndex].p;
            cowPrices[cowsIndex] += (original - storeCounts[storeIndex]) * stores[storeIndex].p;
            if (cowsClone[cowsIndex] == 0) cowsIndex++;
            if (storeCounts[storeIndex] == 0) storeIndex++;
        }
        int rentIndex = 0;
        int origCowsIndex = (cowsIndex == n) ? cowsIndex - 1 : cowsIndex;
        if (cowsIndex < n && cowsClone[cowsIndex] < cows[cowsIndex]) cowsIndex++;
        while (rentIndex < k && cowsIndex < n) {
            currSum += rents[rentIndex++];
            cowsIndex++;
        }
        ans = Math.max(ans, currSum);
        while (origCowsIndex >= 0 && rentIndex < k) {
            currSum -= cowPrices[origCowsIndex--];
            currSum += rents[rentIndex++];
            ans = Math.max(ans, currSum);
        }
        out.println(ans);
        out.close();
        br.close();
    }

    static class Store implements Comparable<Store> {
        long q, p;

        public Store(long q, long p) {
            this.q = q;
            this.p = p;
        }

        @Override
        public int compareTo(Store o) {
            return Long.compare(p, o.p);
        }
    }
}
