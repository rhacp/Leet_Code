package com.andrei.longest_substring_without_repeating_characters;

import java.util.ArrayList;
import java.util.Arrays;

public class App_Four {
    public static void main(String[] args) {
        String s = "abcdxdefgajjqwertyui";
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
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int left = 0;
        char helper = ' ';

        for (int right = 0; right < n; right++) {
            helper = s.charAt(right);
            if (charIndex[s.charAt(right)] >= left) {
                left = charIndex[s.charAt(right)] + 1;
            }
            charIndex[s.charAt(right)] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(helper);
        return maxLength;
    }
}
