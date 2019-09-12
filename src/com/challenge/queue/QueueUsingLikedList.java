package com.challenge.queue;

public class QueueUsingLikedList<E> {

    private Node<E> first, last;
    private int size;

    public void enque(E element) {

        if(first == null) {
            first = new Node<>(element);
            last = first;
        } else {
            Node<E> newNode = new Node<>(element);
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public E dequeue() {
        Node oldFirst = first;
        E ele = first.element;
        first = first.next;
        oldFirst = null;
        size--;
        return ele;
    }

    static class Node<E>{
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
        }
    }

}

class QueueUsingLinkedListTest {
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
