class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private int preIdx = 0;
    private int postIdx = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode curr = new TreeNode(preorder[preIdx]);
        preIdx++;

        if (curr.val != postorder[postIdx]) {
            curr.left = constructFromPrePost(preorder, postorder);
        }
        if (curr.val != postorder[postIdx]) {
            curr.right = constructFromPrePost(preorder, postorder);
        }

        postIdx++;
        return curr;
    }
}
