package com.challenge.queue;

import java.util.Stack;

public class QueueUsingStack<E> {

    private Stack<E> s1 = new Stack<>();
    private Stack<E> s2 = new Stack<>();


    public E dequeue() {
        if(s1.empty()) {
            return null;
        } else {
            return s1.pop();
        }
    }

    public void enque(E element) {
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        s2.push(element);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}

class QueueUsingStackTest{
    public static void main(String[] args) {
        System.out.println("------------------------");
        QueueUsingLikedList<Integer> q3 = new QueueUsingLikedList<>();
        q3.enque(12);
        q3.enque(13);
        q3.enque(14);
        q3.enque(15);
        System.out.println(q3.dequeue());
        System.out.println(q3.dequeue());
        q3.enque(16);
        q3.enque(17);
        System.out.println(q3.dequeue());
        System.out.println(q3.dequeue());
        System.out.println("------------------------");
    }
}
