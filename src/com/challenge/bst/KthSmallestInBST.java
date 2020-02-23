package com.challenge.bst;

/*Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

        Note:
        You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

        Example 1:

        Input: root = [3,1,4,null,2], k = 1
        3
        / \
        1   4
        \
        2
        Output: 1
        Example 2:

        Input: root = [5,3,6,2,4,null,null,1], k = 3
        5
        / \
        3   6
        / \
        2   4
        /
        1
        Output: 3 */

import java.util.ArrayList;
import java.util.List;

public class KthSmallestInBST {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> intArr = inorder(root, new ArrayList<Integer>());

        return intArr.get(k-1);

    }

    public static List<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public static void main(String[] args) {
        KthSmallestInBST bst = new KthSmallestInBST();
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(15);

        n1.left = n2;
        n1.right = n3;

        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        n2.left = n4;
        n2.right = n5;

        TreeNode n6 = new TreeNode(14);
        TreeNode n7 = new TreeNode(16);
        n3.left = n6;
        n3.right = n7;

        System.out.println(kthSmallest(n1, 3));
    }
}
