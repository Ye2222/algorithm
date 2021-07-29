package com.algorithm.datastructure.Tree;

public class Binary_tree {


    public node root = new node(1);
    public static int count = 0;

    public void setCount(){
        count = 0;
    }

    // 确定根不是要删除的节点，递归左子树和右子树
    private void del(node root, int val) {
        // 左节点不为空，且左节点为所删除节点
        if(root.left != null && root.left.val == val){
            // 左节点的左右节点都为空，直接删除
            if(root.left.left == null && root.left.right == null) root.left = null;
            // 左节点的左节点不为空，右节点为空，接上左节点
            else if (root.left.right == null) root.left = root.left.left;
            // 左节点的右节点不为空，左节点为空，接上右节点
            else if (root.left.left == null) root.left = root.left.right;
            // 左节点的左右节点都不为空时，将左节点替代
            else {
                node temp = root.left.right;
                root.left = root.left.left;
                root.left.right = temp;
            }
            return;
        }
        // 右节点不为空，且右节点为所删除节点
        else if(root.right != null && root.right.val == val) {
            // 同上
            // 左节点的左右节点都为空，直接删除
            if(root.right.left == null && root.right.right == null) root.right = null;
                // 左节点的左节点不为空，右节点为空，接上左节点
            else if (root.right.right == null) root.right = root.right.left;
                // 左节点的右节点不为空，左节点为空，接上右节点
            else if (root.right.left == null) root.right = root.right.right;
                // 左节点的左右节点都不为空时，将左节点替代
            else {
                node temp = root.right.right;
                root.right = root.right.left;
                root.right.right = temp;
            }
            return;
        }
        // 左子树进行递归删除
        else if(root.left != null) {
            del(root.left, val);
        }
        // 右子树进行递归删除
        else if(root.right != null) {
            del(root.right, val);
        }
    }

    // 删除节点
    public void delete(node root, int val) {
        if(root != null) {
            if(root.val == val) {
                System.out.println("删除的是根节点");
                root = null;
            }
            else del(root, val);
        }
        else System.out.println("The root is empty");
    }

    // 前序遍历
    public static void preorder(node root) {
        if(root == null) return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // 前序查找
    public static void presearch(node root, int target) {
        count++;
        if(root == null) return;
        if(root.val == target) {
            System.out.println(count);
            return;
        }
        presearch(root.left, target);
        presearch(root.right, target);
    }

    // 中序遍历
    public static void inorder(node root) {
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // 中序查找
    public static void insearch(node root, int target) {
        count++;
        if(root == null) return;
        insearch(root.left, target);
        if(root.val == target) {
            System.out.println(count);
            return;
        }
        insearch(root.right, target);
    }

    // 后序遍历
    public static void postorder(node root) {
        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void postsearch(node root, int target) {
        count++;
        if(root == null) return;
        postsearch(root.left, target);
        postsearch(root.right, target);
        if(root.val == target) {
            System.out.println(count);
            return;
        }
    }
    public static void main(String[] args) {
        Binary_tree t = new Binary_tree();
        t.root.left = new node(2);
        t.root.right = new node(3);

        t.root.left.left = new node(4);
        t.root.left.left.right = new node(8);
        t.root.left.right = new node(5);

        t.root.right.left = new node(6);
        t.root.right.right = new node(7);

        preorder(t.root); // 1 2 4 5 3 6 7
        System.out.println();
        inorder(t.root); // 4 2 5 1 6 3 7
        System.out.println();
        postorder(t.root); // 4 5 2 6 7 3 1
        System.out.println();

        presearch(t.root, 4);
        t.setCount();
        insearch(t.root, 4);
        t.setCount();
        postsearch(t.root, 4);

        t.delete(t.root, 4);
        preorder(t.root);
    }
}

class node{
    node left;
    node right;
    int val;
    public node(){}
    public node(int val) {
        this.val = val;
    }
}
