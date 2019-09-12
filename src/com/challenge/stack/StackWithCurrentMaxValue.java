package com.challenge.stack;

public class StackWithCurrentMaxValue<E extends Number> {

    private Node<Number> first;
    private Node<Number> maxNode;

    private int size;

    public int size() {
        return size;
    }

    public int maximum() {
        return maxNode.element.intValue();
    }

    public void push(Number element) {
        if(first == null) {
            first = new Node<>(element);
            maxNode = first;
        } else {
            Node<Number> oldFirstNode = first;
            first = new Node<>(element);
            first.next = oldFirstNode;
        }
        if(maximum()<=element.intValue()) {
            Node<Number> oldMax = maxNode;
            maxNode = first;
            maxNode.next = oldMax;
        }
        size++;
    }

    public Number pop() {
        if(first == null){
            return null;
        } else {
            Node<Number> oldNode = first;
            Number ele = oldNode.element;
            first = first.next;
            if(maximum()==ele.intValue()) {
                maxNode = maxNode.next;
            }
            oldNode = null;
            return ele;
        }
    }

    static class Node<E extends Number> {
        Number element;
        Node<Number> next;

        public Node(Number element){
            this.element = element;
        }
    }

}

class StackWithCurrentMaxValueTest{

    public static void main(String[] args) {
        System.out.println("------------------------");
        StackWithCurrentMaxValue<Integer> q3 = new StackWithCurrentMaxValue<>();
        q3.push(12);
        q3.push(13);
        q3.push(14);
        q3.push(15);
        System.out.println(q3.pop());
        System.out.println(q3.pop());
        q3.push(16);
        q3.push(17);
        System.out.println("max "+q3.maximum());
        System.out.println(q3.pop());
        System.out.println(q3.pop());
        System.out.println("------------------------");
        System.out.println("max "+q3.maximum());
        q3.push(18);
        q3.push(19);
        System.out.println("max "+q3.maximum());
    }
}

