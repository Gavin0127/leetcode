package tree;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/28 12:12
 */
public class TreeNode {

    private int value;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "value:" + value;
    }
}
