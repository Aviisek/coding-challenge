package com.challenge.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueue<E> {
    private Queue<E> q1 = new LinkedList<>();

    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E element) {
        q1.add(element);
        for (int i =0; i< size; i++){
            q1.add(q1.remove());
        }
        size++;
    }

    public E pop() {
        size--;
        return q1.remove();
    }
}

class TestStackUsingSingleQueue{
    public static void main(String[] args) {
        System.out.println("------------------------");
        StackUsingDoubleQueue<Integer> q3 = new StackUsingDoubleQueue<>();
        q3.push(12);
        q3.push(13);
        q3.push(14);
        q3.push(15);
        System.out.println(q3.pop());
        System.out.println(q3.pop());
        q3.push(16);
        q3.push(17);
        System.out.println(q3.pop());
        System.out.println(q3.pop());
        System.out.println("------------------------");
    }
}
