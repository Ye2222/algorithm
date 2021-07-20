package com.algorithm.datastructure.List;

import java.util.Stack;

public class question {
    Node head = new Node();

    class Node{
        int value;
        Node next;
        public Node(){}
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString(){
            return "(" + value + ")";
        }
    }

    public void add(int x){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(x);
    }

    // 求单链表中有效节点的个数
    public void question1(){
        if(head.next == null) {
            System.out.println(0);
            return;
        }
        Node temp = head;
        int count = 0;
        while(temp.next != null){
            count += 1;
            temp = temp.next;
        }
        System.out.println(count);
    }

    // 查找单链表中的倒数第k个结点
    public void question2(int k){
        if(head.next == null){
            System.out.println("null");
            return;
        }
        int count = 0;
        Node temp = head.next;
        while(temp != null){
            count += 1;
            temp = temp.next;
        }

        int n = count - k + 1;
        if(n <= 0 || n > count){
            System.out.println("There is no such node");
            return;
        }
        count = 0;
        temp = head.next;
        while(temp != null){
            count += 1;
            if(count == n){
                System.out.println(temp);
            }
            temp = temp.next;
        }
    }

    // 单链表的翻转
    public void question3(){
        if(head.next == null){
            System.out.println("null");
            return;
        }
        Node temp = head.next;
        Node newHead = new Node();
        while(temp != null){
            Node temp1 = temp.next;
            temp.next = newHead.next;
            newHead.next = temp;
            temp = temp1;
        }
        head.next = newHead.next;
    }

    // 从尾到头打印单链表
    // 反向遍历后打印，但会破坏原来的结构
    public void question4_1(){
        question3();
        show();

    }
    // 使用栈
    public void question4_2(Node temp){
        if(temp != null){
            question4_2(temp.next);
        }
        if(temp == null) return;
        System.out.println(temp);
    }
    public void question4_2(){
        Stack s = new Stack();
        Node temp = head.next;
        while(temp != null){
            s.add(temp);
            temp = temp.next;
        }
        while(!s.empty()){
            System.out.println(s.pop());
        }
    }
    public void show(){
        Node temp = head.next;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        question q = new question();
        q.add(2);
        q.add(3);
        q.add(40);
        q.add(5);
        q.question4_2();
    }
}
