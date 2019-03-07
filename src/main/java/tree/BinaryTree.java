package tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/28 12:12
 */
public class BinaryTree {

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.println(root.getValue());
        inOrder(root.getRight());
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.getValue());
    }

    public static void BFSOrder(TreeNode root) {
        Queue<TreeNode> stack = new LinkedBlockingQueue<TreeNode>();
        TreeNode top = root;
        while (top != null) {
            System.out.println(top.getValue());
            if (top.getLeft() != null) {
                stack.add(top.getLeft());
            }
            if (top.getRight() != null) {
                stack.add(top.getRight());
            }
            top = stack.poll();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.setLeft(new TreeNode(8));
        TreeNode right = new TreeNode(14);
        right.setLeft(new TreeNode(11));
        right.setRight(new TreeNode(18));
        root.setRight(right);
        BFSOrder(root);
    }

}
