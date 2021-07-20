package com.algorithm.datastructure.List;

public class Linked_List {
    private Node head = new Node();
    public Node[] nodes;

    public Linked_List(){
        nodes = new Node[10];
    }
    public Linked_List(int n){
        nodes = new Node[n];
    }

    public void append(int x){
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(x);
    }

    public void del(int n){
        int count = 0;
        Node temp = head;
        while(temp.next != null){
            if(count + 1 == n) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
            count += 1;
        }
    }

    public void del_last(){
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    public void show(){
        Node temp = head.next;
        while(temp != null) {
            if(temp.next == null) {
                System.out.printf("%d", temp.value);
                break;
            }
            System.out.printf("%d->", temp.value);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Linked_List l = new Linked_List();
        l.append(2);
        l.append(5);
        l.append(6);
        l.append(8);
        l.del(2);
        l.del(3);
        l.show();
    }

    class Node{
        public int value;
        public Node next = null;
        public Node(){}
        public Node(int n){
            value = n;
        }
        public Node(int n, Node next){
            value = n;
            this.next = next;
        }
    }
}
