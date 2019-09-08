package com.challenge;

public class DetectLoopInLinkedList<E> {

    Node<E> head;

    void add(E element){
        Node<E> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
    }

    boolean detectLoop(){
        Node<E> x1 = head;
        Node<E> x2 = head;

        while(x2 != null) {
            x1 = x1.next;
            x2 = x2.next.next;
            if(x1.equals(x2)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node<E> n = head;
        while (n != null){
            sb.append(n.element).append(" ");
            n = n.next;
        }
        return sb.toString();
    }

    static class Node<E> {
        E element;
        Node<E> next;

        Node(E e) {
            this.element = e;
            this.next = null;
        }
    }
}

class Main {
    public static void main(String[] args) {
        DetectLoopInLinkedList<Integer> lList = new DetectLoopInLinkedList<>();

        lList.add(20);
        lList.add(4);
        lList.add(15);
        lList.add(10);

        /*Create loop for testing */
        lList.head.next.next.next.next = lList.head;

        System.out.println(lList.detectLoop());
    }
}
