package com.challenge.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingDoubleQueue<E> {
    private Queue<E> q1 = new LinkedList<>();
    private Queue<E> q2 = new LinkedList<>();
    private int size;

    public void push(E element) {
        q2.add(element);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<E> q = q1;
        q1 = q2;
        q2 = q;
        size++;
    }

    public E pop(){
        size--;
        return q1.remove();
    }

    public E peek(){
        return q1.peek();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println("------------------------");
        StackUsingDoubleQueue<Integer> q3 = new StackUsingDoubleQueue<>();
        q3.push(12);
        q3.push(13);
        q3.push(14);
        q3.push(15);
        System.out.println(q3.pop());
        System.out.println(q3.pop());
        System.out.println(q3.pop());
        System.out.println("------------------------");
    }


}
