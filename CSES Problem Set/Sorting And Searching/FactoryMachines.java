import java.io.*;

public class FactoryMachines {
    static long[] arr;
    static long t;
    public static void main(String[] args) throws Exception {
        FastIO fi = new FastIO(System.in);
        arr = new long[fi.nextInt()];
        t = fi.nextLong();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = fi.nextLong();
        }
        System.out.print(search());
    }

    static long search() {
        long lo = 0, hi = (long) 2E18;
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (check(mid) < t) lo = mid + 1; else hi = mid;
        }
        return lo;
    }

    static double check(long t) {
        double ans = 0;
        for (long l : arr) {
            ans += (t / l);
        }
        return ans;
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
