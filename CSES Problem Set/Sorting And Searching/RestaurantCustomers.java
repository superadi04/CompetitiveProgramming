import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RestaurantCustomers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Customer> add = new PriorityQueue<Customer>();
        PriorityQueue<Customer> remove = new PriorityQueue<Customer>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            add.add(new Customer(a));
            remove.add(new Customer(b));
        }
        int max = 0;
        int i = 0;
        while (add.size() > 0) {
            if (add.peek().time < remove.peek().time) {
                ++i;
                add.poll();
            } else {
                --i;
                remove.poll();
            }
            if (i > max) {
                max = i;
            }
        }
        System.out.print(max);
    }
}

class Customer implements Comparable<Customer> {
    int time;

    public Customer(int a) {
        time = a;
    }

    @Override
    public int compareTo(Customer c) {
        return Integer.compare(time, c.time);
    }
}