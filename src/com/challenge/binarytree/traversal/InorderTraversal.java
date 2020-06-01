package com.challenge.binarytree.traversal;

/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

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

    //recursively
    List<Integer> l = new ArrayList<>();

    public List < Integer > inorderTraversalRecursively(TreeNode root) {
        if(root == null) return l;

        inorderTraversalRecursively(root.left);
        l.add(root.val);
        inorderTraversalRecursively(root.right);

        return l;
    }

    //iteratively
    public List < Integer > inorderTraversalIteratively(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        TreeNode curr = root;

        while(curr != null || !dq.isEmpty()) {

            while(curr != null) {
                dq.push(curr);
                curr = curr.left;
            }
            curr = dq.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
