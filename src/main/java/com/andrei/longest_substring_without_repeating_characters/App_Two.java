package com.andrei.longest_substring_without_repeating_characters;

public class App_Two {

    public static void main(String[] args) {
//        String s = "abcdxdefghjjqwertyui";
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
        String s = "ggububgvfk";
//        String s = "agububgvfk";

        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int remote = 0;
        int remoteSecond = 0;
        int res = 0;
        int helper = 0;
        String firstSubstring = "";
        String secondSubstring = "";
        int helperIndex = 0;

        for (int index = 0; index <= s.length() - 1; index++) {
            if (firstSubstring.indexOf(s.charAt(index)) != -1 && remote == 0) {
                if (secondSubstring.isEmpty() || secondSubstring.length() <= 1) {
                    secondSubstring += firstSubstring.substring(firstSubstring.indexOf(s.charAt(index)) + 1) + s.charAt(index);
                }
                remote = 1;
            } else if (secondSubstring.indexOf(s.charAt(index)) != -1) {
                remoteSecond = 1;
            } else if (remote == 0 && helper == 0) {
                firstSubstring += s.charAt(index);
            } else if (remote == 1) {
                secondSubstring += s.charAt(index);
            }

            if (remoteSecond == 1 || index == s.length() - 1) {
                if (secondSubstring.length() > firstSubstring.length()) {
                    res = secondSubstring.length();
                    remoteSecond = 0;
                    firstSubstring = secondSubstring;
                    secondSubstring = "" + s.charAt(index);
//                    index--;
                    remote = 0;
                } else if (secondSubstring.length() == firstSubstring.length()) {
                    res = secondSubstring.length();
                    remoteSecond = 0;
                    firstSubstring = secondSubstring;
                    secondSubstring = "";
                    remote = 0;
                    helper = 1;
                    index--;
                    if (index == s.length() - 2) {
                        index++;
                    }
                } else {
                    res = firstSubstring.length();
                    remoteSecond = 0;
                    secondSubstring = "";
                }
            }
        }

        return res;
    }
}
