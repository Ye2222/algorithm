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
    // 前序遍历
    public void preOrder() {
        System.out.println(this.val);
        if(this.left != null) this.left.preOrder();
        if(this.right != null) this.right.preOrder();
    }
    // 中序遍历
    public void inOrder() {
        if(this.left != null) this.left.inOrder();
        System.out.print(this.val + " ");
        if(this.right != null) this.right.inOrder();
    }

    // BST的search函数
    public node search(int val) {
        if(this.val == val) return this;
        else if(val < this.val) {
            if (this.left.search(this.val) == null) return null;
            return this.left.search(val);
        }
        else {
            if (this.right.search(this.val) == null) return null;
            return this.right.search(val);
        }
    }

    // BST的searchParent函数
    public node searchParent(int val) {
        // 如果当前节点就是要删除的节点的父节点，就返回
        if((this.left != null && this.left.val == val) ||
                (this.right != null && this.right.val == val)) {
            return this;
        } else {
            // 如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if(val < this.val && this.left != null){
                return this.left.searchParent(val);
            } else if(val >= this.val && this.right != null) {
                return this.right.searchParent(val);
            } else {
                return null; // 没有找到父节点
            }
        }
    }

    // BST的add函数
    public void add(node node) {
        if(node == null) return;
        if(node.val < this.val) {
            // 比当前值小，向左边添加
            if(this.left == null) this.left = node;
            else this.left.add(node);
        }
        else{
            // 比当前值大，向右边添加
            if(this.right == null) this.right = node;
            else this.right.add(node);
        }
    }

    // AVL的add函数
    public void addA(node node) {
        if(node == null) return;
        if(node.val < this.val) {
            // 比当前值小，向左边添加
            if(this.left == null) this.left = node;
            else this.left.add(node);
        }
        else{
            // 比当前值大，向右边添加
            if(this.right == null) this.right = node;
            else this.right.add(node);
        }

        // 当添加完一个结点后，如果：（右子树的高度-左子树的高度）> 1：左旋转
        if(rightHeight() - leftHeight() > 1) {
            // 如果它的右子树的左子树的高度大于它的右子树的右子树的高度
            if(right != null && right.leftHeight() > rightHeight()) {
                // 先对右子节点进行右旋转
                right.rightRotate();
                // 然后在对当前结点进行左旋转
                leftRotate();
            } else {
                // 直接进行左旋转即可
                leftRotate();
            }
            return;
        }

        // 当添加完一个节点后，如果：（左子树的高度-右子树的高度）> 1：右旋转
        if(leftHeight() - rightHeight() > 1) {
            // 如果它的左子树的右子树高度大于它的左子树的高度
            if(left != null && left.rightHeight() > left.leftHeight()) {
                // 先对当前结点的左节点进行左旋转
                left.leftRotate();
                // 再对当前结点进行右旋转
                rightRotate();
            } else {
                // 直接进行右旋转
                rightRotate();
            }
        }
    }

    // 以该节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(),
                        right == null ? 0 : right.height()) + 1;
    }
    // 左子树的高度
    public int leftHeight() {
        if(left == null) return 0;
        return left.height();
    }
    // 右子树的高度
    public int rightHeight() {
        if(right == null) return 0;
        return right.height();
    }

    public void leftRotate() {
        // 创建新的结点，以当前根节点的值
        node newNode = new node(val);

        // 把新的节点的左子树设置成当前节点的左子树
        newNode.left = left;
        // 把新的结点的右子树设置成当前结点的右子树的左子树
        newNode.right = right.left;
        // 把当前结点的值替换成右子节点的值
        val = right.val;
        // 把当前结点的右子树设置成当前结点右子树的右子树
        right = right.right;
        // 把当前结点的左子树(左子节点)设置成新的结点
        left = newNode;
    }

    // 单旋转（右旋转）
    public void rightRotate() {
        // 创建新的结点，赋值当前根节点的值
        node newNode = new node(val);

        // 把新的结点的右子树设置成当前结点的右子树
        newNode.right = right;
        // 把新的节点的左子树设置成当前结点的左子树的右子树
        newNode.left = left.right;
        // 把当前结点的值替换成左子节点的值
        val = left.val;
        // 把当前结点的左子树设置成右子树的左子树
        left = left.left;
        // 把当前结点的右子树设置为新的结点
        right = newNode;
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
