import java.io.*;
import java.util.*;

public class Apartments {
    static long n, m, k;
    public static void main(String[] args) throws Exception {
        FastIO fi = new FastIO(System.in);
        n = fi.nextInt(); m = fi.nextInt(); k = fi.nextLong();
        PriorityQueue<Long> sizes = new PriorityQueue<>();
        for (int i = 0; i < n; i++) sizes.add(fi.nextLong());
        PriorityQueue<Long> apartments = new PriorityQueue<>();
        for (int i = 0; i < m; i++) apartments.add(fi.nextLong());
        long ans = 0;
        while (!sizes.isEmpty() && !apartments.isEmpty()) {
            if (sizes.peek() + k >= apartments.peek() && sizes.peek() - k <= apartments.peek()) {
                ++ans;
                sizes.poll();
                apartments.poll();
            } else {
                if (apartments.peek() < sizes.peek()) {
                    apartments.poll();
                } else {
                    sizes.poll();
                }
            }
        }
        System.out.print(ans);
    }

    static class FastIO {
        InputStream dis;
        byte[] buffer = new byte[1 << 17];
        int pointer = 0;

        public FastIO(String fileName) throws Exception {
            dis = new FileInputStream(fileName);
        }

        public FastIO(InputStream is) throws Exception {
            dis = is;
        }

        int nextInt() throws Exception {
            int ret = 0;

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }

            return (negative) ? -ret : ret;
        }

        long nextLong() throws Exception {
            long ret = 0;

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }

            return (negative) ? -ret : ret;
        }

        byte nextByte() throws Exception {
            if (pointer == buffer.length) {
                dis.read(buffer, 0, buffer.length);
                pointer = 0;
            }
            return buffer[pointer++];
        }

        String next() throws Exception {
            StringBuffer ret = new StringBuffer();

            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            while (b > ' ') {
                ret.appendCodePoint(b);
                b = nextByte();
            }

            return ret.toString();
        }

    }
}

