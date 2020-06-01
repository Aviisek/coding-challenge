package com.challenge.binarytree.traversal;

/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal {

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

    //recursively
    List<Integer> list = new ArrayList<>(); // it can also be passed in recursively
    public List<Integer> postorderTraversalRecursively(TreeNode root) {

        if(root == null) return list;

        postorderTraversalRecursively(root.left);
        postorderTraversalRecursively(root.right);
        list.add(root.val);
        return list;
    }

    //iteratively
    // this is actually a right PREORDER (parent node -> right child ->left child ) and then reverse it.
    public List<Integer> postorderTraversalIteratively(TreeNode root) {

        LinkedList<Integer> list = new LinkedList<>();
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        if(root!=null) dq.push(root);
        while(!dq.isEmpty()){
            TreeNode curr = dq.pop();
            list.addFirst(curr.val); // this is kinda add in reverse fashion.

            if(curr.left != null) dq.push(curr.left);
            if(curr.right != null) dq.push(curr.right);

        }
        return list;
    }
}
