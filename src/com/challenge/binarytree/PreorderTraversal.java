package com.challenge.binarytree;

/*
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

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

      //recursive solution
    List<Integer> l = new ArrayList<>();
    public List<Integer> preorderTraversalRecursively(TreeNode root) {

        if(root == null) return l;

        l.add(root.val);
        preorderTraversalRecursively(root.left);
        preorderTraversalRecursively(root.right);

        return l;

    }

      //iterative traversal
    public List<Integer> preorderTraversalIteratively(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        if(root != null) dq.push(root);

        while(!dq.isEmpty()) {
            TreeNode node = dq.pop();
            l.add(node.val);
            if(node.right != null) dq.push(node.right);
            if(node.left != null) dq.push(node.left);

        }
        return l;
    }
}
