package com.challenge;

public class LinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public void add(E e) {
        linkLast(e);
    }

    public void add(int index, E e) {
        if(index == size){
            linkLast(e);
        } else {
            Node<E> x = node(index);
            Node<E> pre = x.prev;
            Node<E> newNode = new Node<>(pre, e, x);
            x.prev = newNode;
            if(pre == null)
                first = newNode;
            else
                pre.next = newNode;
        }
    }

    public void remove() {
        unLinkLast(last);
    }

    public void remove(E element){
        Node<E> x = first;
        if(element == null) {
            while(x.next != null && x.item != null) {
                x = x.next;
            }
            if(x.item == null) {
                unlinkNode(x);
            }
        } else {
            while(!x.item.equals(element)) {
                x = x.next;
            }
            unlinkNode(x);
        }
    }

    public void remove(int index) {
        Node<E> n = node(index);
        unlinkNode(n);
    }

    public E get(int index) {
        return node(index).item;
    }

    public void set(int index, E element) {
        node(index).item = element;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        while(this.first != null) {
            Node<E> x = first.next;
            first.item = null;
            first.prev = null;
            first.next = null;
            first = x;
        }
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void linkLast(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;

        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private void unLinkLast(Node<E> l){
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null;
        last = prev;

        if(prev == null)
            first = null;
        else
            prev.next = null;
        size--;
    }

    private Node<E> node(int index){
        Node<E> x = first;

        for (int i =0; i<index; i++) {
            x = x.next;
        }
        return x;
    }

    private void unlinkNode(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<E> f = first;
        while(f != null) {
            s.append(f.item).append(" ");
            f = f.next;
        }

        return s.toString();
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next){
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

class Test {

    public static void main(String[] args) {
        LinkedList<Integer> dl = new LinkedList<>();

        dl.add(1);
        dl.add(2);
        dl.add(3);
        dl.add(4);
        dl.add(5);
        System.out.println(dl);
        System.out.println(dl.size());

        dl.remove();
        System.out.println(dl);
        System.out.println(dl.size());

        dl.remove(Integer.valueOf("3"));
        System.out.println(dl);
        System.out.println(dl.size());

        System.out.println(dl.get(0));
        System.out.println(dl.get(1));

        dl.set(0, 9);
        dl.set(1, 8);

        /*System.out.println(dl.get(0));
        System.out.println(dl.get(1));*/
        System.out.println(dl);

        dl.add(0, 5);
        dl.add(2, 6);
        System.out.println(dl);

        dl.add(3, null);
        dl.add(2, null);
        dl.remove(null);
        System.out.println(dl);

        /*dl.clear();
        dl.remove(1);
        System.out.println(dl.size());*/
    }
}

