/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null && inorder == null || preorder.length != inorder.length) {
            return null;
        }

        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int preStart,int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = findIndex(inorder, inStart, inEnd, rootVal);

        int leftSubTreeSize = rootIndex - inStart;

        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubTreeSize, inorder, inStart, rootIndex - 1);
        root.right = buildTreeHelper(preorder, preStart + leftSubTreeSize + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }

     private int findIndex(int[] inorder, int inStart, int inEnd, int rootVal) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return -1; 
    }
}