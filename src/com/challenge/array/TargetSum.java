package com.challenge.array;

/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
    The length of the given array is positive and will not exceed 20.
    The sum of elements in the given array will not exceed 1000.
    Your output answer is guaranteed to be fitted in a 32-bit integer.
 */

public class TargetSum {
    //brute force by considering every options.
    /*
    Complexity Analysis

        Time complexity : O(2^n). Size of recursion tree will be 2^n. n refers to the size of nums array.

        Space complexity : O(n). The depth of the recursion tree can go upto n
     */
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        helper(nums,0,0,S);
        return count;

    }

    public void helper(int[] nums, int i,int sum, int S){
        if(i>nums.length) return;

        if(i == nums.length){
            if(sum == S) {
                count++;
            }
        } else{

            helper(nums, i+1, sum+nums[i], S);
            helper(nums, i+1, sum-nums[i], S);
        }
    }
}
