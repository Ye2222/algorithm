package com.algorithm.datastructure.Tree.The_use_of_tree;

import com.algorithm.datastructure.Tree.node;
import com.algorithm.datastructure.Tree.The_use_of_tree.Binary_sort_tree;
public class AVL_Tree {
    // AVL树 平衡二叉树，二叉搜索树
    // 可以保证查询效率较高
    /*
    1) 平衡二叉树也叫平衡二叉搜索树（Self-balancing binary search tree） 又被称为 AVL 树， 可以保证查询效率较高。
    2) 具有以下特点： 它是一 棵空树或它的左右两个子树的高度差的绝对值不超过 1，
    并且左右两个子树都是一平衡二叉树。
    平衡二叉树的常用实现方法有红黑树、 AVL、 替罪羊树、 Treap、 伸展树等。
     */

    node root;

    // 要求：给定一个数列，创造对应的平衡二叉树
    // 单旋转（左旋转）
    public void leftRotate() {
        // 创建新的结点，以当前根节点的值
        node newNode = new node(root.val);

        // 把新的节点的左子树设置成当前节点的左子树
        newNode.left = root.left;
        // 把新的结点的右子树设置成当前结点的右子树的左子树
        newNode.right = root.right.left;
        // 把当前结点的值替换成右子节点的值
        root.val = root.right.val;
        // 把当前结点的右子树设置成当前结点右子树的右子树
        root.right = root.right.right;
        // 把当前结点的左子树(左子节点)设置成新的结点
        root.left = newNode;
    }

    // 单旋转（右旋转）
    public void rightRotate() {
        // 创建新的结点，赋值当前根节点的值
        node newNode = new node(root.val);

        // 把新的结点的右子树设置成当前结点的右子树
        newNode.right = root.right;
        // 把新的节点的左子树设置成当前结点的左子树的右子树
        newNode.left = root.left.right;
        // 把当前结点的值替换成左子节点的值
        root.val = root.left.val;
        // 把当前结点的左子树设置成右子树的左子树
        root.left = root.left.left;
        // 把当前结点的右子树设置为新的结点
        root.right = newNode;
    }

    // 有些情况单旋转不能完成平衡二叉树的转换
    // 这时候使用双旋转
    /*
    1. 当符合右旋转的条件时
    2. 如果它的左子树的右子树高度大于它的左子树的高度
    3. 先对当前这个结点的左节点进行左旋转
    4. 再对当前结点进行右旋转的操作即可
     */
}
