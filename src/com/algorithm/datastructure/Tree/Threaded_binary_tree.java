package com.algorithm.datastructure.Tree;

public class Threaded_binary_tree {
    /**
     * 1) n 个结点的二叉链表中含有 n+1 【公式 2n-(n-1)=n+1】 个空指针域。
     * 利用二叉链表中的空指针域， 存放指向该结点在某种遍历次序下的前驱和后继结点的指针
     * （这种附加的指针称为"线索"）
     * 2) 这种加上了线索的二叉链表称为线索链表，
     * 相应的二叉树称为线索二叉树(Threaded BinaryTree)。
     * 根据线索性质的不同， 线索二叉树可分为前序线索二叉树、 中序线索二叉树和后序线索二叉树三种
     * 3) 一个结点的前一个结点， 称为前驱结点
     * 4) 一个结点的后一个结点， 称为后继结点
     */

    /**
     * 线索化二叉树后，node节点的属性left和right有两种情况
     * 1）left指向的是左子树，也可能指向前驱结点
     * 2）right指向的是右子树，也可能指向后继结点
     *
     */

    public node root;

    // 为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    // 在递归进行线索化时，pre总是保留前一个结点
    public node pre;
    // 前序线索树
    public void threaded_nodes_preorder() {
        threaded_nodes_preorder(root);
    }
    // 前序线索树
    public void threaded_nodes_preorder(node root) {
        if(root == null) return;

        // 处理当前结点的前驱结点
        if(root.left == null) {
            root.left = pre;
            root.leftType = 1;
        }
        // 处理后驱节点
        if(pre != null && pre.right == null) {
            pre.right = root;
            pre.rightType = 1;
        }
        pre = root;

        // 不加限制条件，会回到前驱结点陷入死循环，1 3 8 3 8 3 8 。。。
        if(root.leftType == 0) threaded_nodes_preorder(root.left);
        if(root.rightType == 0) threaded_nodes_preorder(root.right);
    }

    // 中序线索树
    public void threaded_nodes_inorder() {
        this.threadednodes_inorder(root);
    }
    // 中序线索树
    public void threadednodes_inorder(node root) {
        if (root == null) return;

        // 线索化左子树
        threadednodes_inorder(root.left);

        // 线索化当前结点
        // 处理当前结点的前驱结点
        if(root.left == null) {
            // 让当前结点的左指针指向前驱结点
            root.left = pre;
            root.leftType = 1; // 表示左结点指向的是前驱结点
        }
        // 处理后继结点
        if(pre != null && pre.right == null) {
            // 让前驱结点的右指针指向当前结点
            pre.right = root;
            pre.rightType = 1;
        }
        // 每处理完一个结点后，让当前结点是下一结点的前驱结点
        pre = root;

        // 线索化右子树
        threadednodes_inorder(root.right);
    }

    // 后续线索树
    public void threadednodes_postorder() {
        threadednodes_postorder(root);
    }
    // 后续线索树
    public void threadednodes_postorder(node root) {
        if(root == null) return;

        // 线索化左子树
        if(root.leftType == 0) threadednodes_postorder(root.left);
        // 线索化右子树
        if(root.rightType == 0)threadednodes_postorder(root.right);
//        System.out.print(root.val + " ");
        // 线索化当前结点
        // 处理当前结点的前驱结点
        if(root.left == null) {
            // 让当前结点的左指针指向前驱结点
            root.left = pre;
            root.leftType = 1; // 表示左结点指向的是前驱结点
        }
        // 处理后继结点
        if(pre != null && pre.right == null) {
            // 让前驱结点的右指针指向当前结点
            pre.right = root;
            pre.rightType = 1;
        }
        // 每处理完一个结点后，让当前结点是下一结点的前驱结点
        pre = root;

    }
    // 前序线索树的遍历
    public void threadList_preorder() {
        node temp = root;
        while (temp != null) {
            // 循环地输出leftType == 0 的结点
            // 输出没有前驱的结点，没有处理过的结点
            // 一直往左边走，没有前驱结点，说明它的左边不为空
            while (temp.leftType == 0) {
                System.out.print(temp.val + " ");
                temp = temp.left;
            }
            // 输出当前结点
            System.out.print(temp.val + " ");
            // 此时的结点是最左侧的叶节点，往它的右侧走
            // 往它的后驱节点走
            temp = temp.right;
        }
    }
    // 中序线段树的遍历
    public void threadedList_inorder() {
        node temp = root;
        while (temp != null) {
            // 循环地找到leftType == 1 的结点
            // 后面随着遍历而变化，因为当leftType == 1 时，
            // 说明该结点是按照线索化处理后的有效结点
            while (temp.leftType == 0) {
                temp = temp.left;
            }
            System.out.print(temp.val+" ");
            // 如果当前结点的右指针指向后继结点，则一直输出
            while(temp.rightType == 1) {
                temp = temp.right;
                System.out.print(temp.val+ " ");
            }
            // 会回到当前结点的父节点，此时父节点的rightType为0
            // 说明右边有结点，要往右边走
            // 替换这个遍历的结点
            temp = temp.right;
        }
    }
    // 后序线段树的遍历
    public void threadList_postorder() {
        node temp = root;
        while(temp != null) {
            // 循环地输出rightType == 0 的结点
            // 等于0说明有右子树, 一直往右边走
            while(temp.rightType == 0) {
                System.out.print(temp.val + " ");
                temp = temp.right;
            }
            System.out.print(temp.val + " ");
            // 往左边走，走到前驱结点所在的左边子树
            temp = temp.left;
        }
    }
    public static void main(String[] args) {
        node root = new node(1);

        root.left = new node(3);
        root.right = new node(6);

        root.left.left = new node(8);
        root.left.right = new node(10);

        root.right.left = new node(14);
        root.right.right = new node(16);
        root.right.right.right = new node(19);
        Threaded_binary_tree tree = new Threaded_binary_tree();
        tree.root = root;
        tree.threadednodes_postorder();
        tree.threadList_postorder();
    }

}

