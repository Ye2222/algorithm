package com.algorithm.datastructure.List;

public class stack {

    private Node head = new Node();
    private Node top = new Node();
    public Node[] nodes;

    public void push(int x){
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(x);
        top = temp.next;
    }


    public void pop(){
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        System.out.println(temp.val);
        temp.next = null;
        top = temp;
    }

    public void show(){
        Node temp1 = head;
        while(top != head){
            if(temp1.next == top){
                System.out.println(top.val);
                top = temp1;
                temp1 = head;
                continue;
            }
            temp1 = temp1.next;
        }
    }
    public static void main(String[] args) {
        stack s = new stack();
        s.push(2);
        s.push(3);
        s.push(6);
        s.show();
    }
    class Node{
        int val;
        Node next;
        public Node(){}
        public Node(int val){ this.val = val;}
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

}
