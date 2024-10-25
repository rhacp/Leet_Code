package com.andrei.longest_substring_without_repeating_characters;

import java.util.ArrayList;
import java.util.Collections;

public class App_Three {

    public static void main(String[] args) {
        String s = "abcdxdefghjjqwertyui";
//        String s = "au";
//        String s = "dvdf";
//        String s = "tmmzuxt";
//        String s = "pwwkew";
//        String s = "bbtablud";
//        String s = "aabaab!bb";
//        String s = "bbbbbb";
//        String s = "abcabcabc";
//        String s = "jbpnbwwd";
//        String s = "loddktdji";
//        String s = "ggububgvfk";
//        String s = "agububgvfk";
//        String s = "";

        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        String firstSubstring = "";
        ArrayList<Integer> helperList = new ArrayList<>();
        int rezFirst = 0;

        if (s.isEmpty()){
            return 0;
        }

        for (int index = 1; index <= s.length(); index++) {
            if (firstSubstring.indexOf(s.charAt(index - 1)) != -1) {
                index = index - (firstSubstring.length() - firstSubstring.indexOf(s.charAt(index - 1)));
                rezFirst = (rezFirst > firstSubstring.length()) ? rezFirst : firstSubstring.length();
                firstSubstring = "";
            } else {
                firstSubstring += s.charAt(index - 1);
            }

            if (index == s.length()) {
                rezFirst = (rezFirst > firstSubstring.length()) ? rezFirst : firstSubstring.length();
            }
        }

        return rezFirst;
    }
}
