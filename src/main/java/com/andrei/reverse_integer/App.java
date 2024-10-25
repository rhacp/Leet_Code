package com.andrei.reverse_integer;

public class App {

    public static void main(String[] args) {
//        int x = 90000;
        int x = -123;
//        int x = 10;
//        int x = 1534236469;

        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        int res = 0;

        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (x % 10 > 7)) || res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (x % 10 < -8))) {
                return 0;
            }

            res = res * 10 + (x % 10);
            x /= 10;
        }

        return res;
    }
}
