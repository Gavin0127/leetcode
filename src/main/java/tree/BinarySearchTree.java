package tree;

/**
 * @author : Ge Xiantao
 * @date : 2019/2/28 14:45
 */
public class BinarySearchTree {

    public static TreeNode find(TreeNode root, int data) {
        TreeNode p = root;
        while (p != null) {
            if (data == p.getValue()) {
                return p;
            }
            if (data > p.getValue()) {
                p = p.getRight();
            } else {
                p = p.getLeft();
            }
        }
        return null;
    }

    public static void insert(TreeNode root, int data) {
        if (data > root.getValue()) {
            if (root.getRight() == null) {
                root.setRight(new TreeNode(data));
            } else {
                insert(root.getRight(), data);
            }
            return;
        }
        if (data <= root.getValue()) {
            if (root.getLeft() == null) {
                root.setLeft(new TreeNode(data));
            } else {
                insert(root.getLeft(), data);
            }
            return;
        }
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode p = root;
        while (p != null) {
            if (p.getValue() < key) {
                parent = p;
                p = p.getRight();
                continue;
            } else if (p.getValue() > key) {
                parent = p;
                p = p.getLeft();
                continue;
            }
            // 此节点有两个叶子节点
            if (p.getLeft() != null && p.getRight() != null) {
                TreeNode minP = p.getRight();
                TreeNode minPP = p;
                while (minP.getLeft() != null) {
                    minPP = minP;
                    minP = minP.getLeft();
                }
                p.setValue(minP.getValue());
                p = minP;
                parent = minPP;
            }
            // 此节点只有一个叶子节点
            // 此节点为叶子节点
            TreeNode child;
            if (p.getLeft() != null) {
                child = p.getLeft();
            } else if (p.getRight() != null) {
                child = p.getRight();
            } else {
                child = null;
            }
            if (parent == null) {
                return child;
            }
            if (parent.getLeft() == p) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
            break;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.setLeft(new TreeNode(8));
        TreeNode right = new TreeNode(14);
        right.setLeft(new TreeNode(11));
        right.setRight(new TreeNode(18));
        root.setRight(right);
        deleteNode(root, 14);
    }

}
