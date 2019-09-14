package com.challenge.sorting;

import java.util.Arrays;
import java.util.Collections;

public class KthSelection {

    public int getKthMaxElement(int[] a, int k) {
        int lo=0, hi=a.length-1;

        while (hi>lo){
            int j = partition(a,hi,lo);

            if(j<k-1) lo = j+1;
            else if(j>k-1) hi = j-1;
            else return a[k-1];
        }
        return a[k-1];
    }


    private int partition(int[] a, int hi, int lo) {
        int i =0, j=hi+1;

        while (true) {
            while(a[++i]>a[lo]) {
                if(i==hi) break;
            }

            while(a[--j]<a[lo]) {
                if(j==lo) break;
            }

            if(i>=j) break;

            swap(a,i,j);
        }
        swap(a,lo,j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
}

class TestKthSelection{
    public static void main(String[] args) {
        int[] a = {3,6,5,9,12,3,5,3,7,56,24,14,26};
        Integer[] b = Arrays.stream(Arrays.copyOf(a, a.length))
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(b, Collections.reverseOrder());

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        KthSelection k = new KthSelection();
        System.out.println(k.getKthMaxElement(a, 3));
    }
}
