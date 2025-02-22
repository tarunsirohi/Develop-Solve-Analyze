class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        int[] pos = new int[1];
        int n = traversal.length();
        if (n == 0) return null;
        int rootVal = getVal(traversal, n, pos);
        TreeNode root = new TreeNode(rootVal);
        buildTree(root, 1, traversal, n, pos);
        buildTree(root, 1, traversal, n, pos);
        return root;
    }
    
    private int getVal(String traversal, int n, int[] pos) {
        int val = 0;
        while (pos[0] < n && Character.isDigit(traversal.charAt(pos[0]))) {
            val = val * 10 + (traversal.charAt(pos[0]) - '0');
            pos[0]++;
        }
        return val;
    }
    
    private int getDashLen(String traversal, int n, int[] pos) {
        int originalPos = pos[0];
        while (pos[0] < n && traversal.charAt(pos[0]) == '-') {
            pos[0]++;
        }
        return pos[0] - originalPos;
    }
    
    private void buildTree(TreeNode curr, int expectedDashLen, String traversal, int n, int[] pos) {
        if (pos[0] == n) return;
        int originalPos = pos[0];
        int dashLen = getDashLen(traversal, n, pos);
        if (dashLen != expectedDashLen) {
            pos[0] = originalPos;
            return;
        }
        int nodeVal = getVal(traversal, n, pos);
        TreeNode newNode = new TreeNode(nodeVal);
        if (curr.left == null) {
            curr.left = newNode;
        } else {
            curr.right = newNode;
        }
        buildTree(newNode, expectedDashLen + 1, traversal, n, pos);
        buildTree(newNode, expectedDashLen + 1, traversal, n, pos);
    }
}

class TreeNode {
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