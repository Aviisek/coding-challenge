package com.challenge.sorting;

import java.util.Arrays;

public class QuickShort<E extends Comparable> {

    public E[] elememnts;

    public void sort(E[] a) {
        sort(a, 0, a.length-1);
    }

    private void sort(E[] a, int lo, int hi) {
        if(hi<=lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private int partition(E[] a, int lo, int hi){
        int i =lo, j = hi+1;

        while (true){
            while (a[++i].compareTo(a[lo])<=0) {
                if(i == hi) {
                    break;
                }
            }

            while (a[lo].compareTo(a[--j])<0){
                if(j == lo) {
                    break;
                }
            }

            if(i>=j) break;

            swap(a,i,j);
        }
        swap(a,lo,j);

        return j;
    }

    private void swap(Comparable[] a, int i, int j) {
        Comparable c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
}

class TestQuickShort{
    public static void main(String[] args) {
        Double[] dArr = {1.5, 7.2, 1.2, 1.6, 2.9, 0.2, 1.7};

        QuickShort<Double> ms = new QuickShort<>();
        ms.sort(dArr);

        System.out.println(Arrays.toString(dArr));
    }
}
