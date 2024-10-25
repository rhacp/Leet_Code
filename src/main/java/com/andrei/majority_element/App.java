package com.andrei.majority_element;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        int[] nums = {3,2,3};

        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            freq.put(nums[index], freq.getOrDefault(nums[index], 0) + 1);
        }

        int target = nums.length / 2;

        for (Map.Entry<Integer, Integer> element : freq.entrySet()) {
            if (element.getValue() > target) {
                return element.getKey();
            }
        }

        return 0;
    }
}
