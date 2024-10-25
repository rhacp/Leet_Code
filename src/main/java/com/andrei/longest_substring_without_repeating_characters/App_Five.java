package com.andrei.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class App_Five {

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
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                charMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }

        return maxLength;
    }
}
