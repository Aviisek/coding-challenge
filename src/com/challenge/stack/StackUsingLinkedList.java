package com.challenge.stack;

public class StackUsingLinkedList<E> {

    private Node<E> first;

    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(E element) {
        if(first == null) {
            first = new Node<>(element);
        } else {
            Node<E> oldFirstNode = first;
            first = new Node<>(element);
            first.next = oldFirstNode;
        }
        size++;
    }

    public E pop() {
        if(first == null){
            return null;
        } else {
            Node<E> oldNode = first;
            E ele = oldNode.element;
            first = first.next;
            oldNode = null;
            return ele;
        }
    }

    static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element){
            this.element = element;
        }
    }

}

class StackUsingLinkedListTest{

    public static void main(String[] args) {
        System.out.println("------------------------");
        StackUsingLinkedList<Integer> q3 = new StackUsingLinkedList<>();
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
