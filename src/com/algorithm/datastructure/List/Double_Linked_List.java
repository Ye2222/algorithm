package com.algorithm.datastructure.List;

public class Double_Linked_List {
    public Node head = new Node();
    public Double_Linked_List(){}

    public Node getHead(){ return head;}

    public void add(int value){
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = new Node(value, null, temp);
    }
    public void add_no(int pre_value, int value){
        Node temp = head;
        while(temp.next != null){
            if(temp.value == pre_value){
                Node new_node = new Node(value, temp.next.next, temp.next);
                temp.next = new_node;
                temp.next.next.pre = new_node;
                return;
            }
            temp = temp.next;
        }
    }

    public void delete(){
        if(head.next == null){
            System.out.println("There is no node...");
            return;
        }
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.pre.next = null;
    }

    public void delete(int x){
        if(head.next == null){
            System.out.println("There is no node...");
            return;
        }
        Node temp = head.next;
        while(true){
            if(temp.value == x){
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                return;
            }
            if(temp.next == null){
                System.out.println("There is no such a node...");
                return;
            }
            temp = temp.next;
        }
    }

    public void update(int x, int y){
        if(head.next == null){
            System.out.println("There is no node...");
            return;
        }
        Node temp = head.next;
        while(temp != null){
            if(temp.value == x){
                temp.value = y;
                return;
            }
            temp = temp.next;
        }
        System.out.println("There is no such a node!");
    }
    public void show(){
        if(head.next == null) {
            System.out.println("There is no node");
            return;
        }
        Node temp = head.next;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Double_Linked_List l = new Double_Linked_List();
        l.add(2);
        l.add(3);
        l.add(4);
        l.delete(5);
        l.update(2, 6);
        l.add_no(6, 7);
        l.show();
    }
    class Node{
        int value;
        Node next;
        Node pre;
        public Node(){}
        public Node(int value){ this.value = value;}
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        public Node(int value, Node next, Node pre){
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
        @Override
        public String toString(){
            return "(" + value + ")";
        }
    }
}
