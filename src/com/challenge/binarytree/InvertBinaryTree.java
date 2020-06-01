package com.challenge.binarytree;

/*
    Invert a binary tree.

    Example:

    Input:

         4
       /   \
      2     7
     / \   / \
    1   3 6   9
    Output:

         4
       /   \
      7     2
     / \   / \
    9   6 3   1

 */

import java.util.ArrayDeque;

public class InvertBinaryTree {

    //Definition for a binary tree node.
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  //using DFS
  public TreeNode invertTreeRecursively(TreeNode root) {
      if(root == null) return root;

      TreeNode right = invertTreeRecursively(root.right);
      TreeNode left = invertTreeRecursively(root.left);

      root.left = right;
      root.right = left;

      return root;
  }

  //using BFS
    public TreeNode invertTreeIteratively(TreeNode root) {
        if(root == null) return root;

        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        while(!dq.isEmpty()) {
            TreeNode curr = dq.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if(curr.right != null) dq.offer(curr.right);
            if(curr.left != null) dq.offer(curr.left);
        }
        return root;
    }
}
