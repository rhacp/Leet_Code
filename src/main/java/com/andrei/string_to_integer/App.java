package com.andrei.string_to_integer;

public class App {

    public static void main(String[] args) {
//        String s = " -042";
//        String s = "-91283472332";
//        String s = "-+12";
        String s = "-21474836482";

        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        int res = 0;
        int sign = 0;
        int help = 0;
        int switcher = 0;
        s = s.trim();

        for (int index = 0; index < s.length(); index++) {
            if ((!Character.isDigit(s.charAt(index)) && s.charAt(index) != '-' && s.charAt(index) != '+') || (switcher != 0 && s.charAt(index) == '-') || (switcher != 0 && s.charAt(index) == '+')) {
                break;
            }

            if (help == 1 && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
                help = 2;
                break;
            }

            if (switcher == 0 && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
                help = 1;
            }

            if (switcher == 0 && s.charAt(index) == '-') {
                sign = 1;
            }

            if (sign == 0 && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (((int) (s.charAt(index) - '0')) >= 7)))) {
                return Integer.MAX_VALUE;
            }

            if (sign == 1 && (res > (Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && (((int) (s.charAt(index) - '0')) >= 8)))){
                return Integer.MIN_VALUE;
            }

            if (Character.isDigit(s.charAt(index))) {
                switcher = 1;
                res = res * 10 + (int) (s.charAt(index) - '0');
            }
        }

        if (sign == 1) {
            res *= -1;
        }

        return res = help == 2 ? 0 : res;
    }
}
