package com.challenge.sorting;

/*
    Dutch national flag. Given an array of N buckets, each containing a red, white, or blue pebble, sort them by color. The allowed operations are:
    swap(i,j): swap the pebble in bucket i with the pebble in bucket j.
    color(i): color of pebble in bucket i.
    The performance requirements are as follows:
    At most N calls to color().
    At most N calls to swap().
    Constant extra space.
     */

import java.util.Arrays;

public class DutchNationalFlag {

    private Pebble[] pebbles;

    public void setPebbles(Pebble[] pebbles) {
        this.pebbles = pebbles;
    }

    private Pebble color(int i) {
        return pebbles[i];
    }

    private int compare(Pebble p) {
        return p.ordinal() - Pebble.White.ordinal();
    }

    public Pebble[] getPebbles() {
        return pebbles;
    }

    private void swap(int i, int j) {
        Pebble tmp = pebbles[i];
        pebbles[i] = pebbles[j];
        pebbles[j] = tmp;
    }

    public void sort(){
        int lo = 0, mid = 0, hi = pebbles.length-1;

        while (mid<=hi) {
            Pebble currPebble = color(mid);
            int c = compare(currPebble);

            if(c<0){
                swap(mid++,lo++);
            }
            else if(c>0) {
                swap(mid,hi--);
            }
            else {
                mid++;
            }
        }

    }

}

class Test{
    public static void main(String[] args) {
        DutchNationalFlag df = new DutchNationalFlag();
        df.setPebbles(new Pebble[] {
                Pebble.White, Pebble.Blue, Pebble.Red,
                Pebble.Red, Pebble.Blue, Pebble.White,
                Pebble.Blue, Pebble.Red, Pebble.White
                });

        df.sort();
        System.out.println(Arrays.toString(df.getPebbles()));
    }
}

enum Pebble {
    Red,
    White,
    Blue
}
