package com.andrei.contains_duplicate;

import java.util.HashMap;
import java.util.HashSet;

public class App {

    public static void main(String[] args) {
        int[] nums = {9,5,3,2,5};
        // 5 3 2 5 9
        //

        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
//        HashMap<Integer, Integer> holder = new HashMap<>();
        HashSet<Integer> holderTwo = new HashSet<>();

        for (int index = 0; index < nums.length; index++) {
            if (holderTwo.contains(nums[index])) {
                return true;
            }

            holderTwo.add(nums[index]);
        }

        return false;
    }
}
