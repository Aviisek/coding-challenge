package com.challenge.sorting;

import java.util.Arrays;

public class MergeSort {

    private Comparable[] a;

    public void setA(Comparable[] a) {
        this.a = a;
    }

    public Comparable[] getA() {
        return a;
    }

    public void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }

    public void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        //System.arraycopy(a, lo, aux, lo, (hi-lo+1));
        for (int i =lo; i<=hi; i++) {
            aux[i] = a[i];
        }

        int i = lo, j=mid+1;

        for(int k = lo; k<=hi; k++) {
            if (i>mid)                          a[k] = aux[j++];
            else if (j>hi)                      a[k] = aux[i++];
            else if(aux[j].compareTo(aux[i])<0) a[k] = aux[j++];
            else                                a[k] = aux[i++];
        }

    }
}

class TestMergeShort{
    public static void main(String[] args) {
        Double[] dArr = {1.5, 7.2, 1.2, 1.6, 2.9, 0.2, 1.7};

        MergeSort ms = new MergeSort();
        ms.sort(dArr);

        System.out.println(Arrays.toString(dArr));
    }
}
