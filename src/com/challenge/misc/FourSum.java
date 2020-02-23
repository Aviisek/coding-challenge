package com.challenge.misc;

import java.util.HashMap;
import java.util.Map;

/*Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1. */

public class FourSum {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : D) {
            for(int j: C)
                if(map.containsKey(i+j)) {
                    map.put(i+j, map.get(i+j)+1);
                } else {
                    map.put(i+j, 1);
                }
        }

        int count = 0;

        for (int x : A) {
            for (int y : B) {
                if (map.containsKey(-(x + y))) {
                    count += map.get(-(x + y));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //ans-2
        System.out.println(fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}));
    }
}
