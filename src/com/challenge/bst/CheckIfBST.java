package com.challenge.bst;

class CheckIfBST<K extends Comparable<K>,V> {

    class Node {
        K key;
        V value;
        Node left;
        Node right;

        Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public boolean checkForBST(Node root, Node left, Node right) {
        if (root == null) return true;
        else return !(right != null && root.key.compareTo(right.key) >= 0)
                && !(left != null && root.key.compareTo(left.key) <= 0)
                && (checkForBST(root.left, left, root) && checkForBST(root.right, root, right));
       /* else if (root.right !=null && root.key.compareTo(root.right.key)>0) return false;
        else if (root.left != null && root.key.compareTo(root.left.key)<0) return false;
        else if (!(checkForBST(root.left) && checkForBST(root.right))) return false;
        return true;*/
    }
}

class CheckIfBstTest {
    public static void main(String[] args) {
        CheckIfBST<Integer, Integer> bst = new CheckIfBST<>();
        CheckIfBST<Integer, Integer>.Node n1 = bst.new Node(10, 10, null, null);
        CheckIfBST<Integer, Integer>.Node n2 = bst.new Node(5, 5, null, null);
        CheckIfBST<Integer, Integer>.Node n3 = bst.new Node(15, 15, null, null);
        n1.left = n2;
        n1.right = n3;

        CheckIfBST<Integer, Integer>.Node n4 = bst.new Node(3, 3, null, null);
        CheckIfBST<Integer, Integer>.Node n5 = bst.new Node(7, 7, null, null);
        n2.left = n4;
        n2.right = n5;

        CheckIfBST<Integer, Integer>.Node n6 = bst.new Node(13, 13, null, null);
        CheckIfBST<Integer, Integer>.Node n7 = bst.new Node(17, 17, null, null);
        n3.left = n6;
        n3.right = n7;

        System.out.println(bst.checkForBST(n1, null, null));

    }
}
