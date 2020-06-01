package com.challenge.binarytree.traversal;

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if( root == null) return list;

        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        while(!dq.isEmpty()) {
            List<Integer> l = new ArrayList<>();

            int i = dq.size();

            while(i-->0){
                TreeNode curr = dq.poll();
                l.add(curr.val);
                if(curr.left != null) dq.offer(curr.left);
                if(curr.right != null) dq.offer(curr.right);
            }

            list.add(l);
        }
        return list;
    }
}
