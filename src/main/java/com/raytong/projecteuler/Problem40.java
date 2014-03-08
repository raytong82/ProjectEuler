package com.raytong.projecteuler;

public class Problem40 {
    public static void main(String[] args) throws Exception {
        int total = 1;
        total *= unit(1);
        total *= unit(10);
        total *= unit(100);
        total *= unit(1000);
        total *= unit(10000);
        total *= unit(100000);
        total *= unit(1000000);
        System.out.println(total);
    }
    
    public static int unit(int n) throws Exception {
        if (n < 10) {
            return n;
        } else if (n <= 9 + 90 * 2) {
            int num = n - 9;
            return unit(num, 10);
        } else if (n <= 9 + 90 * 2 + 900 * 3) {
            int num = n - (9 + 90 * 2);
            return unit(num, 100);
        } else if (n <= 9 + 90 * 2 + 900 * 3 + 9000 * 4) {
            int num = n - (9 + 90 * 2 + 900 * 3);
            return unit(num, 1000);
        } else if (n <= 9 + 90 * 2 + 900 * 3 + 9000 * 4 + 90000 * 5) {
            int num = n - (9 + 90 * 2 + 900 * 3 + 9000 * 4);
            return unit(num, 10000);
        } else if (n <= 9 + 90 * 2 + 900 * 3 + 9000 * 4 + 90000 * 5 + 900000 * 6) {
            int num = n - (9 + 90 * 2 + 900 * 3 + 9000 * 4 + 90000 * 5);
            return unit(num, 100000);
        }
        throw new Exception("not implemented");
    }
    
    private static int unit(int num, int offset) {
        int pos = 0;
        int length = String.valueOf(offset).length();
        pos = num % length - 1;
        if (pos < 0) {
            pos += length;
            num -= 1;
        }
        num /= length;
        num += offset;
        return String.valueOf(num).charAt(pos) - '0';
    }
    
}
