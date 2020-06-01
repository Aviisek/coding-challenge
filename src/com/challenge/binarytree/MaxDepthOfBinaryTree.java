package com.challenge.binarytree;

public class MaxDepthOfBinaryTree {

   // Definition for a binary tree node.
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //bottom-up recursion
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int l = maxDepth(root.left);
        int j = maxDepth(root.right);

        return Math.max(l,j)+1;
    }


   //to-down recursion
   int depth = 0;
    public int maxDepthTopDown(TreeNode root) {
        if(root == null) return 0;

        helper(root,1);

        return depth;

    }

    private void helper(TreeNode root, int depth) {

        if(root == null) return;

        if(root.left == null && root.right == null){
            this.depth = Math.max(this.depth,depth);
        }

        helper(root.left, depth+1);
        helper(root.right, depth+1);

    }
}
