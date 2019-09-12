package com.challenge.sorting;

import java.util.Arrays;

class SelectionSort {

    public void sort(Comparable[] a) {

        for(int i =0; i< a.length; i++) { //O(N2/2)
            int minIndex = i;
            for (int j = i+1; j< a.length; j++) {
                if(a[j].compareTo(a[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(a, minIndex, i); // N-exchange
        }
    }

    private void swap(Comparable[] a, int i, int j) {
        Comparable c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
}

class TestSelectionSort {

    public static void main(String[] args) {
        Double[] intArr = {1.5, 7.2, 1.2, 1.6, 2.9, 0.2, 1.7};

        SelectionSort s = new SelectionSort();
        s.sort(intArr);

        System.out.println(Arrays.toString(intArr));
    }

}
