package com.challenge.recursion.tree;

import java.util.HashMap;
import java.util.LinkedList;

import static java.util.Comparator.comparingInt;

public class BuildWordFrequencyBinaryTree {


    static  class Node {
        final String word;
        final int count;
        final Node left;
        final Node right;

        Node(String word, int count, Node left, Node right){
            this.word = word;
            this.count = count;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "word='" + word + '\'' +
                    ", count=" + count +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {

        String sentence = "This is one of the really really interesting question out of all interesting question";

        var map = new HashMap<String, Integer>();
        LinkedList<Node> nodeList = new LinkedList<>();

        for(String word: sentence.split(" ")){
            map.merge(word, 1, Integer::sum);
        }

        for (var entry: map.entrySet()){
            nodeList.add(new Node(entry.getKey(), entry.getValue(), null, null));
        }
        nodeList.sort(comparingInt(a -> a.count));

        buildTreeRecursive(nodeList, 0);

        printBinaryTree(nodeList.getFirst(), 0);
    }

    public static void buildTreeRecursive(LinkedList<Node> nodeList, int level){

        if(nodeList.size() == 1) return;

        Node firstNode = nodeList.removeFirst();
        Node secondNode = nodeList.removeFirst();

        Node mergedNode = new Node("level-"+level+"-",firstNode.count+ secondNode.count, firstNode, secondNode);
        nodeList.addFirst(mergedNode);
        buildTreeRecursive(nodeList, level+1);
    }

    public static void printBinaryTree(Node root, int level){
        if(root==null)
            return;
        printBinaryTree(root.right, level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
            System.out.println("|--------"+root.word+"["+root.count+"]");
        }
        else{
            System.out.println(root.word+"["+root.count+"]");
        }
        printBinaryTree(root.left, level+1);
    }
}

