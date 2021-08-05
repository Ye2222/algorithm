package com.algorithm.datastructure.Tree;

public class Binary_sequential_tree {
    /**
     * 数组可以转换成树， 树也可以转换成数组
     * 顺序存储二叉树
     * 1) 顺序二叉树通常只考虑完全二叉树
     * 2) 第 n 个元素的左子节点为 2 * n + 1
     * 3) 第 n 个元素的右子节点为 2 * n + 2
     * 4) 第 n 个元素的父节点为 (n-1) / 2
     * 5) n : 表示二叉树中的第几个元素
     */

    public int[] arr;

    public Binary_sequential_tree(int[] nums){
        arr = nums;
    }

    // 前序遍历
    public void pre_order() {
        this.pre_order(0);
    }

    public void pre_order(int index) {
        if(arr == null || arr.length == 0) System.out.println("数组为空");
        // 输出当前的元素
        System.out.print(arr[index] + " ");

        // 向左递归
        if((index * 2 + 1) < arr.length) {
            pre_order(2 * index + 1);
        }

        // 向右递归
        if((index * 2 + 2) < arr.length) {
            pre_order(2 * index + 2);
        }
    }

    // 中序遍历
    public void in_order() {
        this.in_order(0);
    }
    public void in_order(int index) {
        if(arr == null || arr.length == 0) System.out.println("数组为空");

        // 向左递归
        if((index * 2 + 1) < arr.length) {
            in_order(2 * index + 1);
        }

        // 输出当前的元素
        System.out.print(arr[index] + " ");

        // 向右递归
        if((index * 2 + 2) < arr.length) {
            in_order(2 * index + 2);
        }
    }

    // 后序遍历
    public void post_order() {
        this.post_order(0);
    }
    public void post_order(int index) {
        if(arr == null || arr.length == 0) System.out.println("数组为空");

        // 向左递归
        if((index * 2 + 1) < arr.length) {
            post_order(2 * index + 1);
        }

        // 向右递归
        if((index * 2 + 2) < arr.length) {
            post_order(2 * index + 2);
        }

        // 输出当前的元素
        System.out.print(arr[index] + " ");
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Binary_sequential_tree tree = new Binary_sequential_tree(nums);
        tree.pre_order(); // 1 2 4 5 3 6 7
        System.out.println();
        tree.in_order(); // 4 2 5 1 6 3 7
        System.out.println();
        tree.post_order();
    }
}
