package main.java.com.alg.tree;

/**
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * <p>
 * 示例1：
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * <p>
 * 示例2：
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 104] 之间。
 * 1 <= Node.val <= 100
 */
public class DeepestLeavesSum {

    int maxDeep = 1;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        deep(root, 1);
        return sum;
    }

    public void deep(TreeNode root, int curDeep) {
        if (root == null) {
            return;
        }

        if (curDeep == maxDeep) {
            sum = sum + root.val;
        }

        if (curDeep > maxDeep) {
            maxDeep = curDeep;
            sum = root.val;
        }

        deep(root.left, curDeep + 1);
        deep(root.right, curDeep + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
