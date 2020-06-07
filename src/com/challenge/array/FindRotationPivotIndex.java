package com.challenge.array;

public class FindRotationPivotIndex {

    public static int findRotateIndex(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if (nums[left] < nums[right])
            return 0;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findRotateIndex(new int[]{4,5,6,7,0,1,2}));
    }
}
