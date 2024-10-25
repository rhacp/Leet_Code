package com.andrei.longest_substring_without_repeating_characters;

public class App {

    public static void main(String[] args) {
        String s = "abcddefghjjqwertyui";
//        String s = "au";
//        String s = "dvdf";
//        String s = "tmmzuxt";
//        String s = "pwwkew";
//        String s = "bbtablud";
//        String s = "aabaab!bb";

        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int remote = 0;
        int remoteSecond = 0;
        int res = 0;
        String firstSubstring = "";
        String secondSubstring = "";

        for (int index = 0; index <= s.length() - 1; index++) {
            if (firstSubstring.indexOf(s.charAt(index)) != -1 || secondSubstring.indexOf(s.charAt(index)) != -1) {
                if (remote == 1) {
                    remoteSecond = 1;
                    remote = 2;
                    if (firstSubstring.indexOf(s.charAt(index)) != -1 && secondSubstring.indexOf(s.charAt(index)) == -1) {
                        secondSubstring += s.charAt(index);
                    }
                } else {
                    if (secondSubstring.length() == 0) {
                        secondSubstring += firstSubstring.substring(firstSubstring.indexOf(s.charAt(index)));
                    }
                    remote = 1;
                }
            } else if (remote == 0){
                firstSubstring += s.charAt(index);
            } else if (remote == 1 || remote == 2) {
                secondSubstring += s.charAt(index);
            }

            if (remoteSecond == 1 || index == s.length() - 1) {
                if (secondSubstring.length() > firstSubstring.length()) {
                    res = secondSubstring.length();
                    remoteSecond = 0;
                    firstSubstring = secondSubstring;
                    secondSubstring = "";
                    index--;
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
