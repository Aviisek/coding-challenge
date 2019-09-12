package com.challenge.sorting;

import java.util.Arrays;

public class InsertionSort {

    public void sort(Comparable[] a) {
        for(int i = 0; i<a.length; i++) {
            for (int j =i; j>0; j--) {
                if(a[j].compareTo(a[j-1]) < 0) {
                    swap(a,j,j-1);
                } else {
                    break;
                }
            }
        }
    }

    private void swap(Comparable[] a, int i, int j) {
        Comparable c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
}

class TestInsertionSort {

    public static void main(String[] args) {
        Double[] intArr = {1.5, 7.2, 1.2, 1.6, 2.9, 0.2, 1.7};

        InsertionSort i = new InsertionSort();
        i.sort(intArr);

        System.out.println(Arrays.toString(intArr));
    }

}
