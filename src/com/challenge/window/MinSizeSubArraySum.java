package com.challenge.window;

/*

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

 */

public class MinSizeSubArraySum {

    public int minSubArrayLen(int s, int[] nums) {

        int len = nums.length+1, sum = 0, start = 0;

        for(int i =0; i< nums.length; i++) {
            sum+=nums[i];

            while(sum>=s){
                len = Math.min(len,i-start+1);
                sum-=nums[start++];
            }
        }
        return len == nums.length+1 ? 0 : len;
    }
}
