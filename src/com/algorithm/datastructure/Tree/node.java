package com.algorithm.datastructure.Tree;

// 为了让 Node 对象持续排序 Collections 集合排序
// 让 Node 实现 Comparable 接口
public class node implements Comparable<node>{
    // 不写(default)–包内可访问
    // public–都可访问
    // protected–包内和子类可访问
    // 类内可访问
    public node left;
    public node right;
    public int val;
    public int weight; // 权重
    public Byte data; // 数据
    int leftType; // 0表示的是左子树，1表示指向前驱节点
    int rightType; // 0表示指向右子树，1表示指向后继结点
    public node(){}
    public node(int val) {
        this.val = val;
    }
    public node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }
    // 写一个前序遍历
    public void preOrder() {
        System.out.println(this.val);
        if(this.left != null) this.left.preOrder();
        if(this.right != null) this.right.preOrder();
    }

    @Override
    public String toString() {
        return "node{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(node o) {
        // 表示从小到大排序
        return this.val - o.val;
    }
}
