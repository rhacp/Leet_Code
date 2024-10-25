package com.andrei.zigzag;

public class App {

    public static void main(String[] args) {
        String s = "ABCDEFGHIJK";
        int numRow = 4;

        System.out.println(convert(s, numRow));
    }

    /*
        |    |   | 1    7      13
        |   /|  /| 2  6 8   12 14
        | /  | / | 3 5  9 11   15
        |    |   | 4    10     16
        * */

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        StringBuilder res = new StringBuilder();
        int counter = 0;
        int help = 0;

        for (int index = 0; index < rows.length; index++) {
            rows[index] = new StringBuilder();
        }

        for (int index = 0; index < s.length(); index++) {
            rows[counter].append(s.charAt(index));

            if (help == 0) {
                counter++;
            } else if (help == 1) {
                counter--;
            }

            if (counter == numRows - 1) {
                help = 1;
            } else if (counter == 0) {
                help = 0;
            }
        }

        for (int index = 0; index < rows.length; index++) {
            res.append(rows[index]);
        }

        return res.toString();
    }
}
