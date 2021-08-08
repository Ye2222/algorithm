package com.algorithm.datastructure.Tree;

public class Binary_sort_tree {
    // 二叉排序树
    // 高效的完成对数据的查询和添加

    // 数组
    /*
     * 数组未排序， 优点： 直接在数组尾添加， 速度快。 缺点： 查找速度慢.
     * 数组排序，
     *  优点： 可以使用二分查找， 查找速度快，
     *  缺点： 为了保证数组有序， 在添加新数据时， 找到插入位置后， 后面的数据需整体移动， 速度慢。
     */

    // 链表
    // 不管链表是否有序， 查找速度都慢， 添加数据速度比数组快， 不需要数据整体移动。

    // 二叉搜索树 BST
    // 对于二叉排序树的任何一个非叶子节点，要求左子节点的值比当前节点的值小
    // 右子节点的值比当前节点的值大
    // 特别说明：如果有相同值，可以将该节点放在左子节点或右子节点

    public node root;

    // 添加
    // 根节点为空，则赋给根节点
    public void add(int val) {
        node node = new node(val);
        if(root == null) root = node;
        else root.add(node);
    }
    public void add(node node) {
        if(root == null) root = node;
        else root.add(node);
    }

    // 查找要删除的节点
    public node search(int val) {
        if(root == null) return null;
        else return root.search(val);
    }
    // 查找父节点
    public node searchParent(int val) {
        if(root == null) return null;
        else return root.searchParent(val);
    }
    //编写方法:
    //1. 返回的 以 node 为根结点的二叉排序树的最小结点的值
    //2. 删除 node 为根结点的二叉排序树的最小结点
    // 找到右子树的最小值
    /**
     *
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以 node 为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(node node) {
        node target = node;
        // 循环的查找左子节点，就会找到最小值
        while(target.left != null) target = target.left;
        // 这时target就指向了最小结点
        // 删除最小结点
        del(target.val);
        return target.val;
    }
    // 找到左子树的最大值
    public int delLeftTreeMax(node node) {
        node target = node;
        while(target.right != null) target = target.right;
        del(target.val);
        return target.val;
    }

    // 删除 有三个情况：
    // 删除叶子节点
    // 删除只有一颗子树的节点
    // 删除有两颗子树的节点
    public void del(int val) {
        if(root == null) return;

        // 第一种情况 删除叶子节点
        // 1. 需要先去找到要删除的节点 targetNode
        node targetnode = search(val);
        // 如果没有找到要删除的节点
        if(targetnode == null) return;
        // 如果当前二叉搜索树只有一个节点
        if(root.left == null && root.right == null) {
            root = null;
            return;
        }
        // 2. 找到targetNode的父节点parent
        node parent = searchParent(val);
        if(targetnode.left == null && targetnode.right == null) {
            // 判断targetnode是父节点的左子节点，还是右子节点
            if(parent.left != null && parent.left.val == val) {
                // 左子节点
                parent.left = null;
            } else if(parent.right != null && parent.right.val == val) {
                // 右子节点
                parent.right = null;
            }
        } else if(targetnode.left != null && targetnode.right != null) {
            // 3. 确定targetNode是parent的左子节点还是右子节点
            // 删除有两颗子树的节点
            // 找到右子树最小的节点代替目标节点
            int minVal = delRightTreeMin(targetnode.right);
            targetnode.val = minVal;
        } else {
            // 4. 根据前面情况进行删除
            //    parents.left = null
            //    parents.right = null
            // 删除只有一颗子树的节点
            // 如果要删除的结点有左子节点
            if(targetnode.left != null) {
                if(parent != null) {
                    if (parent.left.val == val) {
                        // 如果targetnode是parent的左子节点
                        parent.left = targetnode.left;
                    } else {
                        // targetnode是parent的左子节点
                        parent.right = targetnode.left;
                    }
                }
                else {
                    root = targetnode.left;
                }
            } else {
                // 如果要删除的结点有右子节点
                if(parent != null) {
                    // 如果targetnode是parent的左子节点
                    if(parent.left.val == val) {
                        parent.left = targetnode.right;
                    } else {
                        // 如果targetnode是parent的右子节点
                        parent.right = targetnode.right;
                    }
                }
                else {
                    root = targetnode.right;
                }
            }
        }




    }
    public static void main(String[] args) {
        Binary_sort_tree bst = new Binary_sort_tree();
        bst.add(7);
        bst.add(3);
        bst.add(1);
        bst.add(5);
        bst.add(10);
        bst.add(9);
        bst.add(12);

    }
}
